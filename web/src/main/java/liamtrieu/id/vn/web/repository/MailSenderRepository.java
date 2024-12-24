package liamtrieu.id.vn.web.repository;

import liamtrieu.id.vn.web.entity.MailSender;
import liamtrieu.id.vn.web.infrastructure.constant.CategoryMail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailSenderRepository extends JpaRepository<MailSender, String> {
    MailSender findByCode(CategoryMail code);
}
