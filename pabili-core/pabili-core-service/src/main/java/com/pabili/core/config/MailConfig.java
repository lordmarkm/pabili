package com.pabili.core.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@PropertySource("classpath:mail.properties")
public class MailConfig {

    @Autowired
    private Environment env;

    @Bean
    public JavaMailSender javaMailService() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        Properties mailProperties = new Properties();
        mailProperties.put("mail.smtp.auth", env.getProperty("mail.smtp.auth"));
        mailProperties.put("mail.smtp.starttls.enable", env.getProperty("mail.smtp.starttls.enable"));
        mailSender.setJavaMailProperties(mailProperties);
        mailSender.setHost(env.getProperty("mail.host"));
        mailSender.setPort(env.getProperty("mail.port", Integer.class));
        mailSender.setProtocol(env.getProperty("mail.protocol"));
        mailSender.setUsername(env.getProperty("mail.username"));
        mailSender.setPassword(env.getProperty("mail.password"));
        return mailSender;
    }

    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(100);
        return taskExecutor;
    }
}
