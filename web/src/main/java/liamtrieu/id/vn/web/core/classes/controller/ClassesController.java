package liamtrieu.id.vn.web.core.classes.controller;

import liamtrieu.id.vn.web.core.classes.model.AddPointRequest;
import liamtrieu.id.vn.web.core.classes.model.ChangeStatusRequest;
import liamtrieu.id.vn.web.core.classes.model.ClassLessonResponse;
import liamtrieu.id.vn.web.core.classes.model.ClassStudentResponse;
import liamtrieu.id.vn.web.core.classes.model.ClassesRequest;
import liamtrieu.id.vn.web.core.classes.model.ClassesResponse;
import liamtrieu.id.vn.web.core.classes.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/classes")
public class ClassesController {
    @Autowired
    private ClassesService service;

    @GetMapping
    public Page<ClassesResponse> getClasses(Integer page, Integer size, String searchText) {
        return service.getAllClasses(page, size, searchText);
    }

    @GetMapping("/{id}")
    public ClassesResponse getClasses(@PathVariable Long id) {
        return service.getClassesId(id);
    }

    @GetMapping("/student/{code}")
    public Map<String, Object> getClasses(@PathVariable String code, String searchText) {
        return service.getStudentInClass(searchText, code);
    }

    @GetMapping("/point/student/{code}")
    public List<ClassStudentResponse> getPointClasses(@PathVariable String code, String searchText) {
        return service.getStudentClass(searchText, code);
    }

    @GetMapping("/lesson/{code}")
    public List<ClassLessonResponse> getClasses(@PathVariable String code) {
        return service.getAllLessonClasses(code);
    }

    @PostMapping("/lesson/change-status")
    public ChangeStatusRequest changeStatusLesson(@RequestBody ChangeStatusRequest request) {
        return service.changeStatus(request);
    }

    @GetMapping("/schedule/{code}")
    public Map<String, Object> getSchedule(@PathVariable String code,
                                           Integer page, Integer size) {
        return service.getAllScheduleClasses(code, page, size);
    }

    @PostMapping("/add")
    public ClassesRequest addClasses(@RequestBody ClassesRequest request) {
        return service.addClasses(request);
    }

    @PutMapping("/add-student-class/{codeClass}")
    public Boolean addClasses(@PathVariable String codeClass, @RequestBody List<Long> listIdStudent) {
        return service.addStudentClass(codeClass, listIdStudent);
    }

    @PostMapping("/update")
    public ClassesRequest updateClasses(@RequestBody ClassesRequest request) {
        return service.updateClasses(request);
    }

    @PostMapping("/add-point")
    public Boolean addPoint(@RequestBody AddPointRequest addPointRequest) {
        return service.addPoint(addPointRequest);
    }

    @DeleteMapping("/remove/{id}")
    public Boolean addClasses(@PathVariable Long id) {
        return service.removeClasses(id);
    }


}