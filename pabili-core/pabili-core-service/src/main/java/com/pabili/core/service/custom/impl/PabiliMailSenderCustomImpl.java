package com.pabili.core.service.custom.impl;

import java.io.IOException;
import java.util.Map;

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
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.pabili.core.service.custom.PabiliMailSender;

import freemarker.template.TemplateException;

@Component
public class PabiliMailSenderCustomImpl implements PabiliMailSender {

    private static Logger LOG = LoggerFactory.getLogger(PabiliMailSenderCustomImpl.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Environment env;

    @Autowired
    private TaskExecutor taskExecutor;

    @Autowired
    private FreeMarkerConfigurer freemarkerConfig;

    private class EmailNotificationTask implements Runnable {

        private String emailTo;
        private String subject;
        private String text;
        private Function<String, Object> callback;

        public EmailNotificationTask(String emailTo, String subject, String text, Function<String, Object> callback) {
            this.emailTo = emailTo;
            this.subject = subject;
            this.text = text;
            this.callback = callback;
        }

        @Override
        public void run() {
            try {
                //Prepare email details
                MimeMessage mimeMessage = javaMailSender.createMimeMessage();
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                message.setSubject(subject);
                message.setFrom(env.getProperty("mail.from"));
                message.setTo(emailTo);

                message.setText(text, true);
                javaMailSender.send(mimeMessage);
                if (null != callback) {
                    callback.apply(text);
                }
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void sendRegistrationToken(String email, String registrationToken) {
        LOG.debug("Sending registration token. email={}", email);
        Map<String, Object> model = Maps.newHashMap();
        model.put("registrationToken", registrationToken);
        String text = "Welcome to pabili.com.ph! Please complete your registration.";
        try {
            text = FreeMarkerTemplateUtils.processTemplateIntoString(
                    freemarkerConfig.getConfiguration().getTemplate("email/registration_confirmation.html"), model);
        } catch (IOException | TemplateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        EmailNotificationTask task = new EmailNotificationTask(
                email,
                "Welcome to pabili.com.ph! Please complete your registration.",
                text,
                new Function<String, Object>() {
                    @Override
                    public Object apply(String emailText) {
                        LOG.debug("Email successfully sent");
                        return null;
                    }
                });
        taskExecutor.execute(task);
    }

}
