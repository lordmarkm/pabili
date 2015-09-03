package com.pabili.postings.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.pabili.postings.service",
        repositoryImplementationPostfix = "CustomImpl")
public class PostingsConfig {

}
