package liamtrieu.id.vn.web.core.teacher.service;

import liamtrieu.id.vn.web.core.teacher.model.TeacherClassRequest;
import liamtrieu.id.vn.web.core.teacher.model.TeacherRequest;
import liamtrieu.id.vn.web.core.teacher.model.TeacherResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

public interface TeacherService {
    Page<TeacherResponse> getPageTeacher(Integer page, Integer size, String searchText);

    List<TeacherResponse> getAllTeacher();

    TeacherRequest addTeacher(TeacherRequest teacher);

    TeacherResponse getTeacherId(Long id);

    Boolean removeTeacher(Long id);

    TeacherRequest updateTeacher(TeacherRequest teacher);

    Set<TeacherResponse> getTeacherClass(TeacherClassRequest request);
}
