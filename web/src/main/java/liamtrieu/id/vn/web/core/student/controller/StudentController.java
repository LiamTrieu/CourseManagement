package liamtrieu.id.vn.web.core.student.controller;

import liamtrieu.id.vn.web.core.student.model.StudentRequest;
import liamtrieu.id.vn.web.core.student.model.StudentResponse;
import liamtrieu.id.vn.web.core.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping
    public Page<StudentResponse> getStudent(Integer page, Integer size, String searchText) {
        return service.getAllStudent(page, size, searchText);
    }

    @GetMapping("/course/{code}")
    public Page<StudentResponse> getStudentCourse(@PathVariable String code, Integer page, Integer size, String searchText) {
        return service.getAllStudentCourse(code, page, size, searchText);
    }

    @GetMapping("/{id}")
    public StudentResponse getStudent(@PathVariable Long id) {
        return service.getStudentId(id);
    }

    @PostMapping("/add")
    public StudentRequest addStudent(@RequestBody StudentRequest student) {
        return service.addStudent(student);
    }

    @PostMapping("/update")
    public StudentRequest updateStudent(@RequestBody StudentRequest student) {
        return service.updateStudent(student);
    }

    @DeleteMapping("/remove/{id}")
    public Boolean addStudent(@PathVariable Long id) {
        return service.removeStudent(id);
    }
}
