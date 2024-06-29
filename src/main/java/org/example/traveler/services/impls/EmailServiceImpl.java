package org.example.traveler.services.impls;

import org.example.traveler.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public void sendConfirmationToken(String email,String token) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("fredrick.mclaughlin46@ethereal.email");
        message.setTo("fredrick.mclaughlin46@ethereal.email");
        message.setSubject("Confirmation Email");

        String res = "http://localhost:9095/auth/confirm?email="+email+"&token="+token;
        message.setText(res);

        javaMailSender.send(message);
    }
}
