package com.pabili.security.resource;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.pabili.commons.dto.CompleteRegistrationForm;
import com.pabili.commons.dto.EmailRegistrationForm;
import com.pabili.core.model.user.RegistrationToken;
import com.pabili.core.model.user.User;
import com.pabili.core.model.user.UserProfile;
import com.pabili.core.service.RegistrationTokenService;
import com.pabili.core.service.UserProfileService;
import com.pabili.core.service.custom.PabiliMailSender;
import com.pabili.security.service.UserService;

@Controller
@RequestMapping("/login/register")
public class RegistrationResource {

    private static Logger LOG = LoggerFactory.getLogger(RegistrationResource.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private RegistrationTokenService registrationTokenService;

    @Autowired
    private PabiliMailSender mailSender;

    @RequestMapping(method = POST)
    public ModelAndView registerEmail(EmailRegistrationForm registrationForm) {
        LOG.debug("Registration request received. processing. email={}", registrationForm.getEmail());
        RegistrationToken registrationToken = userProfileService.createRegistrationToken(registrationForm);
        if (registrationToken != null) {
            mailSender.sendRegistrationToken(registrationForm.getEmail(), registrationToken.getToken());
            return new ModelAndView("registration/view/email_sent");
        } else {
            return new ModelAndView("registration/view/registration_duplicate");
        }
    }

    @RequestMapping(value = "/consume_token/{token}", method = GET)
    public ModelAndView consumeRegistrationToken(@PathVariable String token) {
        RegistrationToken registrationToken = registrationTokenService.findByToken(token);
        if (null != registrationToken) {
            return new ModelAndView("registration/view/complete_registration")
                .addObject("token", registrationToken);
        } else {
            return new ModelAndView("registration/view/registration_token_not_found");
        }
    }

    @RequestMapping(value = "/consume_token/{token}", method = POST)
    @Transactional
    public ModelAndView completeRegistration(HttpServletRequest request, @PathVariable String token, CompleteRegistrationForm registrationForm) {
        LOG.debug("Complete registration request. form={}", registrationForm);

        //This should not be necessary with js validation, but on pw mismatch redirect to previous page
        if (!registrationForm.passwordMatch()) {
            return new ModelAndView(new RedirectView(request.getHeader("Referer")));
        }

        RegistrationToken registrationToken = registrationTokenService.findByToken(token);
        if (null == registrationToken) {
            return new ModelAndView("registration/view/registration_token_not_found");
        }

        User user = userService.completeRegistration(registrationToken, registrationForm);
        userProfileService.completeRegistration(user);
        LOG.debug("Registration successfully completed!");

        return new ModelAndView(new RedirectView("/login/register/complete"));
    }

    @RequestMapping(value = "/complete", method = GET)
    public ModelAndView registrationComplete() {
        return new ModelAndView("registration/view/registration_complete");
    }
}
