package ls.hvacaretaker.commonlogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Klasa warstwy usług klienta mailowego.
 */
@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SimpleMailMessage preConfiguredMessage;

    /**
     * Metoda pozwalająca na wysłanie wiadomości email.
     *
     * @param to      adresat wiadomości
     * @param subject tytuł wiadomości
     * @param body    treść wiadomości
     */
    public void sendMail(String to, String subject, String body)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

    /**
     * Metoda wysyłająca prekonfigurowaną wiadomość email
     *
     * @param message obiekt prekonfigurowanej wiadomości email
     */
    public void sendPreConfiguredMail(String message)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }
}
