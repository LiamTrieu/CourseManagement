package liamtrieu.id.vn.web.core.lesson.controller;

import liamtrieu.id.vn.web.core.lesson.model.LessonRequest;
import liamtrieu.id.vn.web.core.lesson.model.LessonResponse;
import liamtrieu.id.vn.web.core.lesson.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/lesson")
public class LessonController {
    @Autowired
    private LessonService service;

    @GetMapping("/page/{idCourse}")
    public Page<LessonResponse> getCourse(@PathVariable Long idCourse, Integer page, Integer size, String searchText) {
        return service.getLessonByCourse(page, size, searchText, idCourse);
    }

    @GetMapping("/course/{idCourse}")
    public List<LessonResponse> getLessonCourse(@PathVariable Long idCourse) {
        return service.getLessonCourse(idCourse);
    }

    @GetMapping("/class/page/{codeClass}")
    public Page<LessonResponse> getCourse(@PathVariable String codeClass, Integer page, Integer size, String searchText) {
        return service.getLessonByClass(page, size, searchText, codeClass);
    }

    @GetMapping("/page")
    public Page<LessonResponse> getCourse(Integer page, Integer size, String searchText) {
        return service.getLesson(page, size, searchText);
    }

    @GetMapping("/{lessonId}")
    public LessonResponse getCourse(@PathVariable Long lessonId) {
        return service.getLessonById(lessonId);
    }

    @PostMapping("/add")
    public LessonRequest addLesson(@RequestBody LessonRequest lesson) {
        return service.addLesson(lesson);
    }

    @PostMapping("/update")
    public LessonRequest updateLesson(@RequestBody LessonRequest lesson) {
        return service.updateLesson(lesson);
    }

    @DeleteMapping("/remove/{id}")
    public Boolean addLesson(@PathVariable Long id) {
        return service.removeLesson(id);
    }
}
