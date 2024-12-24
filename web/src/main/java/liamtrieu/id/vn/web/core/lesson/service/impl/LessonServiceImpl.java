package liamtrieu.id.vn.web.core.lesson.service.impl;

import liamtrieu.id.vn.web.core.lesson.model.LessonRequest;
import liamtrieu.id.vn.web.core.lesson.model.LessonResponse;
import liamtrieu.id.vn.web.core.lesson.repository.LessonManagerRepository;
import liamtrieu.id.vn.web.core.lesson.service.LessonService;
import liamtrieu.id.vn.web.entity.Lesson;
import liamtrieu.id.vn.web.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    private LessonManagerRepository lessonManagerRepository;

    @Override
    public LessonRequest addLesson(LessonRequest lesson) {
        Lesson lessonAdd = lesson.tranferLesson(lesson, new Lesson());
        lessonManagerRepository.save(lessonAdd);
        return lesson.lessTranfer(lessonAdd);
    }

    @Override
    public Boolean removeLesson(Long id) {
        lessonManagerRepository.deleteById(id);
        return true;
    }

    @Override
    public LessonRequest updateLesson(LessonRequest lesson) {
        Lesson user = lesson.tranferLesson(lesson, lessonManagerRepository.findById(lesson.getId()).orElseThrow());
        return lesson.lessTranfer(lessonManagerRepository.save(user));
    }

    @Override
    public Page<LessonResponse> getLessonByCourse(Integer page, Integer size, String searchText, Long idCourse) {
        Pageable pageable = PageRequest.of(page, size);
        return lessonManagerRepository.getLessonCourseId(pageable, searchText, idCourse);
    }

    @Override
    public LessonResponse getLessonById(Long lessonId) {
        return lessonManagerRepository.getLessonId(lessonId);
    }

    @Override
    public Page<LessonResponse> getLesson(Integer page, Integer size, String searchText) {
        Pageable pageable = PageRequest.of(page, size);
        return lessonManagerRepository.getLesson(pageable, searchText);
    }

    @Override
    public Page<LessonResponse> getLessonByClass(Integer page, Integer size, String searchText, String codeClass) {
        Pageable pageable = PageRequest.of(page, size);
        return lessonManagerRepository.getLessonClass(pageable, searchText, codeClass);
    }

    @Override
    public List<LessonResponse> getLessonCourse(Long idCourse) {
        return lessonManagerRepository.getLessonCourse(idCourse);
    }
}
