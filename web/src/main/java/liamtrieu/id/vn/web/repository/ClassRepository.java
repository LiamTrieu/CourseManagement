package liamtrieu.id.vn.web.repository;

import liamtrieu.id.vn.web.entity.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Classes, Long> {
}
