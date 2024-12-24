package liamtrieu.id.vn.web.core.teacher.controller;

import liamtrieu.id.vn.web.core.teacher.model.TeacherClassRequest;
import liamtrieu.id.vn.web.core.teacher.model.TeacherRequest;
import liamtrieu.id.vn.web.core.teacher.model.TeacherResponse;
import liamtrieu.id.vn.web.core.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
    @Autowired
    private TeacherService service;

    @GetMapping("/page")
    public Page<TeacherResponse> getTeacher(Integer page, Integer size, String searchText) {
        return service.getPageTeacher(page, size, searchText);
    }

    @GetMapping
    public List<TeacherResponse> getAllTeacher(Integer page, Integer size, String searchText) {
        return service.getAllTeacher();
    }

    @GetMapping("/class")
    public Set<TeacherResponse> getTeacherClass(@ModelAttribute TeacherClassRequest request) {
        return service.getTeacherClass(request);
    }

    @GetMapping("/{id}")
    public TeacherResponse getTeacher(@PathVariable Long id) {
        return service.getTeacherId(id);
    }

    @PostMapping("/add")
    public TeacherRequest addTeacher(@RequestBody TeacherRequest teacher) {
        return service.addTeacher(teacher);
    }

    @PostMapping("/update")
    public TeacherRequest updateTeacher(@RequestBody TeacherRequest teacher) {
        return service.updateTeacher(teacher);
    }

    @DeleteMapping("/remove/{id}")
    public Boolean addTeacher(@PathVariable Long id) {
        return service.removeTeacher(id);
    }
}
