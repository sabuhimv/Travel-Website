package org.example.traveler.controllers;

import org.example.traveler.models.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {
    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/contact")
    public String contact(Model model){
        model.addAttribute("contactForm", new ContactForm());
        return "/pages/contact";
    }

    @PostMapping("/contact")
    public String submitContactForm(ContactForm contactForm, Model model) {
        try {
            sendEmail(contactForm);
            model.addAttribute("successMessage", "Your message has been sent successfully.");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "There was an error sending your message. Please try again later.");
        }
        return "contact";
    }
    private void sendEmail(ContactForm contactForm) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("ibrahim.klein11@ethereal.email");
        message.setSubject(contactForm.getSubject());
        message.setText("Name: " + contactForm.getName() + "\n" +
                "Email: " + contactForm.getEmail() + "\n" +
                "Message: " + contactForm.getMessage());
        mailSender.send(message);
    }

}
