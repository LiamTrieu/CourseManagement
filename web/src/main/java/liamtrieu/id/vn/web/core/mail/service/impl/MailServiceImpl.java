package liamtrieu.id.vn.web.core.mail.service.impl;

import liamtrieu.id.vn.web.core.mail.service.MailService;
import liamtrieu.id.vn.web.entity.MailSender;
import liamtrieu.id.vn.web.repository.MailSenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private MailSenderRepository mailSenderRepository;

    @Override
    public List<MailSender> getAllMail() {
        return mailSenderRepository.findAll();
    }

    @Override
    public MailSender getMailId(String id) {
        return mailSenderRepository.findById(id).orElseThrow();
    }

    @Override
    public MailSender updateMail(MailSender mail) {
        mailSenderRepository.save(mail);
        return mail;
    }

}
