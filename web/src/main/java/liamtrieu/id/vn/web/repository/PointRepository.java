package liamtrieu.id.vn.web.repository;

import liamtrieu.id.vn.web.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {
}
