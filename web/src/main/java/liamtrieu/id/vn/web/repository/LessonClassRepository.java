package liamtrieu.id.vn.web.repository;

import liamtrieu.id.vn.web.entity.LessonClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonClassRepository extends JpaRepository<LessonClass, String> {
}
