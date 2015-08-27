package com.pabili.security.resource;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pabili.commons.dto.CompleteRegistrationForm;
import com.pabili.commons.dto.EmailRegistrationForm;
import com.pabili.core.model.user.RegistrationToken;
import com.pabili.core.service.RegistrationTokenService;
import com.pabili.core.service.UserProfileService;
import com.pabili.core.service.custom.PabiliMailSender;

@Controller
@RequestMapping("/login/register")
public class RegistrationResource {

    private static Logger LOG = LoggerFactory.getLogger(RegistrationResource.class);

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
            mailSender.sendRegistrationToken("lordmarkm@gmail.com", registrationToken.getToken());
            return new ModelAndView("registration/view/registration_success");
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

    @RequestMapping(value = "/complete")
    public ModelAndView completeRegistration(CompleteRegistrationForm registrationForm) {
        return null;
    }
}
