package com.pabili.core.service.custom.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.pabili.core.service.custom.PabiliMailSender;

@Component
public class PabiliMailSenderCustomImpl implements PabiliMailSender {

    private static Logger LOG = LoggerFactory.getLogger(PabiliMailSenderCustomImpl.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Environment env;

    @Autowired
    private TaskExecutor taskExecutor;

    private class EmailNotificationTask implements Runnable {

        private String emailTo;
        private String subject;
        private String text;

        public EmailNotificationTask(String emailTo, String subject, String text) {
            this.emailTo = emailTo;
            this.subject = subject;
            this.text = text;
        }

        @Override
        public void run() {
            try {
                //Prepare email details
                MimeMessage mimeMessage = javaMailSender.createMimeMessage();
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                message.setSubject(subject);
                message.setFrom(env.getProperty("pabili.com.ph@gmail.com"));
                message.setTo(emailTo);

                message.setText(text, true);
                javaMailSender.send(mimeMessage);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void sendRegistrationToken(String email, String registrationToken) {
        LOG.debug("Sending registration token. email={}", email);
        EmailNotificationTask task = new EmailNotificationTask(
                email,
                "Welcome to pabili.com.ph! Please complete your registration.",
                "Hello world");
        taskExecutor.execute(task);
    }

}
