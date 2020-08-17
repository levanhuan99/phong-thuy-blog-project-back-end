package com.project.medium.controllers;

import com.project.medium.model.Sendmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class SendmailController {
    @Autowired
    public JavaMailSender emailSender;

    @ResponseBody
    @PostMapping("/sendSimpleEmail")
    public String sendSimpleEmail(@RequestBody Sendmail data) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(data.getEmail());
        message.setSubject("Test Simple Email");
        message.setText(data.getHref());

        this.emailSender.send(message);

        return "Email Sent!";
    }




}
