package liamtrieu.id.vn.web.core.student.service;

import liamtrieu.id.vn.web.core.student.model.StudentRequest;
import liamtrieu.id.vn.web.core.student.model.StudentResponse;
import org.springframework.data.domain.Page;

public interface StudentService {
    Page<StudentResponse> getAllStudent(Integer page, Integer size, String searchText);

    StudentRequest addStudent(StudentRequest student);

    StudentResponse getStudentId(Long id);

    Boolean removeStudent(Long id);

    StudentRequest updateStudent(StudentRequest student);

    Page<StudentResponse> getAllStudentCourse(String code, Integer page, Integer size, String searchText);
}
