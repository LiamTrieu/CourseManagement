package liamtrieu.id.vn.web.core.course.service;

import liamtrieu.id.vn.web.core.course.model.CourseRequest;
import liamtrieu.id.vn.web.core.course.model.CourseResponse;
import liamtrieu.id.vn.web.core.course.model.LessonCourseRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CourseService {
    Page<CourseResponse> getAllCourse(Integer page, Integer size, String searchText);

    List<CourseResponse> getAllCourse();

    CourseResponse getCourseId(Long id);

    CourseRequest addCourse(CourseRequest course);

    CourseRequest updateCourse(CourseRequest request);

    LessonCourseRequest addLessonCourse(LessonCourseRequest request);

}
