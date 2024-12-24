package liamtrieu.id.vn.web.repository;

import liamtrieu.id.vn.web.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
