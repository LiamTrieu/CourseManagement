package liamtrieu.id.vn.web.core.classes.repository;

import liamtrieu.id.vn.web.entity.Point;
import liamtrieu.id.vn.web.repository.PointRepository;

import java.util.Optional;

public interface PointClassRepository extends PointRepository {

    Optional<Point> findByClassesIdAndLessonIdAndStudentId(Long classes_id, Long lesson_id, Long student_id);
}
