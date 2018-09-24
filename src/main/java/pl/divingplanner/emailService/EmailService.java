package pl.divingplanner.emailService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.divingplanner.model.Email;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void send(Email email) {

        MimeMessage mail = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(email.getAddress());
            helper.setReplyTo("divingplanner@gmail.com");
            helper.setFrom("divingplanner@gmail.com");
            helper.setSubject(email.getTitle());
            helper.setText(email.getContent());
        } catch (MessagingException e) {
            e.printStackTrace();
        } finally {
        }
        javaMailSender.send(mail);
    }

}