package liamtrieu.id.vn.web.repository;

import liamtrieu.id.vn.web.entity.CourseLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseLessonRepository extends JpaRepository<CourseLesson, String> {
}
