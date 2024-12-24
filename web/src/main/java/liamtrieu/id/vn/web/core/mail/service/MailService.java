package liamtrieu.id.vn.web.core.mail.service;

import liamtrieu.id.vn.web.entity.MailSender;

import java.util.List;

public interface MailService {
    List<MailSender> getAllMail();

    MailSender getMailId(String id);

    MailSender updateMail(MailSender mail);
}
