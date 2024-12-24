package liamtrieu.id.vn.web.core.student.service.impl;

import liamtrieu.id.vn.web.core.security.UserService;
import liamtrieu.id.vn.web.core.student.model.StudentRequest;
import liamtrieu.id.vn.web.core.student.model.StudentResponse;
import liamtrieu.id.vn.web.core.student.repository.StudentRepository;
import liamtrieu.id.vn.web.core.student.service.StudentService;
import liamtrieu.id.vn.web.entity.Course;
import liamtrieu.id.vn.web.entity.User;
import liamtrieu.id.vn.web.infrastructure.EmailServiceImpl;
import liamtrieu.id.vn.web.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    UserService userService;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private EmailServiceImpl emailService;


    @Override
    public Page<StudentResponse> getAllStudent(Integer page, Integer size, String searchText) {
        Pageable pageable = PageRequest.of(page, size);
        return studentRepository.getAllStudent(pageable, "%" + searchText + "%");
    }

    @Override
    public StudentRequest addStudent(StudentRequest student) {
        student.setCode(userService.checkCode(userService.genCodeStudent(student.getName()), 0));
        User user = student.tranferUser(student, new User());
        user.setCode(student.getCode());
        user.setEmail(student.getEmail());
        Course course = courseRepository.findById(student.getCourseId()).orElseThrow();
        course.getCourseStudents().add(user);
        courseRepository.save(course);
        emailService.sendDangKyKhoa(student.getEmail(), student.getName(), course.getName());
        return student;
    }


    @Override
    public StudentResponse getStudentId(Long id) {
        return studentRepository.getStudentById(id).orElseThrow();
    }

    @Override
    public Boolean removeStudent(Long id) {
        studentRepository.deleteById(id);
        return true;
    }

    @Override
    public StudentRequest updateStudent(StudentRequest student) {
        User user = student.tranferUser(student, studentRepository.findById(student.getId()).orElseThrow());
        user.setEmail(student.getEmail());
        return student.userTranfer(studentRepository.save(user));
    }

    @Override
    public Page<StudentResponse> getAllStudentCourse(String code, Integer page, Integer size, String searchText) {
        Pageable pageable = PageRequest.of(page, size);
        return studentRepository.getAllStudentCourseId(code, "%" + searchText + "%", pageable);
    }


}
