package liamtrieu.id.vn.web.core.classes.service;

import liamtrieu.id.vn.web.core.classes.model.AddPointRequest;
import liamtrieu.id.vn.web.core.classes.model.ChangeStatusRequest;
import liamtrieu.id.vn.web.core.classes.model.ClassLessonResponse;
import liamtrieu.id.vn.web.core.classes.model.ClassStudentResponse;
import liamtrieu.id.vn.web.core.classes.model.ClassesRequest;
import liamtrieu.id.vn.web.core.classes.model.ClassesResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface ClassesService {
    Page<ClassesResponse> getAllClasses(Integer page, Integer size, String searchText);

    ClassesRequest addClasses(ClassesRequest request);

    ClassesResponse getClassesId(Long id);

    Boolean removeClasses(Long id);

    ClassesRequest updateClasses(ClassesRequest request);

    Map<String, Object> getStudentInClass(String searchText, String code);

    Boolean addStudentClass(String codeClass, List<Long> listIdStudent);

    List<ClassLessonResponse> getAllLessonClasses(String code);

    Boolean addPoint(AddPointRequest request);

    List<ClassStudentResponse> getStudentClass(String searchText, String code);

    Map<String, Object> getAllScheduleClasses(String code, Integer page, Integer size);

    ChangeStatusRequest changeStatus(ChangeStatusRequest request);
}
