package com.pabili.security.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pabili.security.service.PabiliUserDetailsService;

/**
 * @author Mark Martinez, created Sep 2, 2015
 */
@Configuration
@EnableWebSecurity
@EnableJpaRepositories(basePackages = "com.pabili.security.service",
    repositoryImplementationPostfix = "CustomImpl")
@EnableAspectJAutoProxy
public class PabiliSecurityConfig extends WebSecurityConfigurerAdapter {

    private static Logger LOG = LoggerFactory.getLogger(PabiliSecurityConfig.class);

    @Autowired
    private PabiliUserDetailsService userDetailsService;

    @PostConstruct
    public void init() {
        LOG.debug("Configuring security.");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public TextEncryptor textEncryptor() {
        return Encryptors.noOpText();
    }

    @Override
    public void configure(WebSecurity builder) throws Exception {
        builder
            .ignoring()
                .antMatchers("/css/**","/images/**","/javascript/**","/lib/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                //Webapp urls
                .antMatchers("/**").permitAll()
                .and()
            .logout()
                .deleteCookies("JSESSIONID")
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
            .formLogin()
                .loginPage("/auth/login")
                .loginProcessingUrl("/login/authenticate")
                .failureUrl("/#/login?msg=bad_credentials")
                .permitAll();
//                .and()
//            .rememberMe()
//                .key(env.getProperty("remember.me.key"));
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService);
    }
}
