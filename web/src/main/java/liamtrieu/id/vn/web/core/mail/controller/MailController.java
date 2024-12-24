package liamtrieu.id.vn.web.core.mail.controller;

import liamtrieu.id.vn.web.core.mail.service.MailService;
import liamtrieu.id.vn.web.entity.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/mail")
public class MailController {
    @Autowired
    private MailService service;

    @GetMapping
    public List<MailSender> getAllMail() {
        return service.getAllMail();
    }

    @GetMapping("/{id}")
    public MailSender getMail(@PathVariable String id) {
        return service.getMailId(id);
    }

    @PostMapping("/update")
    public MailSender updateMail(@RequestBody MailSender mail) {
        return service.updateMail(mail);
    }

}
