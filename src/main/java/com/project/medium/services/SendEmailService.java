package com.project.medium.services;

import com.project.medium.model.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
@Service
public class SendEmailService {
    private JavaMailSender javaMailSender;


    @Autowired
    public void MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }



    public void sendEmail(SendMail sendMail) throws MailException {


        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(sendMail.getEmailAddress());
        mail.setSubject("Testing Mail API");
        mail.setText("Phong ahaha");


        javaMailSender.send(mail);
    }


    public void sendEmailWithAttachment(SendMail sendMail) throws MailException, MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setTo(sendMail.getEmailAddress());
        helper.setSubject("Testing Mail API with Attachment");
        helper.setText("Please find the attached document below.");

        ClassPathResource classPathResource = new ClassPathResource("Attachment.pdf");
        helper.addAttachment(classPathResource.getFilename(), classPathResource);

        javaMailSender.send(mimeMessage);
    }

    public void setEmailAddress(String emailAddress) {
    }
}
