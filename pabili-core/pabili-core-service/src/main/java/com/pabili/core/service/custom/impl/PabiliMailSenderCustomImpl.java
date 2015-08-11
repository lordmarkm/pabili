package com.pabili.core.service.custom.impl;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.pabili.core.service.custom.PabiliMailSender;

@Component
public class PabiliMailSenderCustomImpl implements PabiliMailSender {

    private static Logger LOG = LoggerFactory.getLogger(PabiliMailSenderCustomImpl.class);

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendRegistrationToken(String email, String registrationToken) {
        LOG.debug("Sending registration token. email={}", email);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("pabili.com.ph");
        message.setTo(email);
        message.setSubject("Welcome to pabili.com.ph! Please complete your registration.");
        message.setText("Dude. Testerino. token=" + registrationToken);
        mailSender.send(message);

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

}
