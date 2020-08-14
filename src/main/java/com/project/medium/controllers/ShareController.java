package com.project.medium.controllers;

import com.project.medium.model.SendMail;
import com.project.medium.repository.ShareRepository;
import com.project.medium.services.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequestMapping(value = "api/album/")
public class ShareController {



    @Autowired
    private SendEmailService sendEmailService;

    @Autowired
    private ShareRepository shareRepository;

    @RequestMapping("send-mail")
    public String send() {



        sendEmailService.setEmailAddress("");


        return "Congratulations! Your mail has been send to the user.";
    }


    @RequestMapping("send-mail-attachment")
    public String sendWithAttachment() throws MessagingException {


        sendEmailService.setEmailAddress("Jarvesblue2@gmail.com");



        return "Congratulations! Your mail has been send to the user.";
    }
}
