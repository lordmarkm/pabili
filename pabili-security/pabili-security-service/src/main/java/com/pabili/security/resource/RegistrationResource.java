package com.pabili.security.resource;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pabili.commons.dto.CompleteRegistrationForm;
import com.pabili.commons.dto.EmailRegistrationForm;
import com.pabili.commons.operations.OperationResult;
import com.pabili.core.model.user.RegistrationToken;
import com.pabili.core.service.RegistrationTokenService;
import com.pabili.core.service.UserProfileService;
import static com.pabili.commons.operations.OperationResult.*;

@Controller
@RequestMapping("/login/register")
public class RegistrationResource {

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private RegistrationTokenService registrationTokenService;

    @RequestMapping(method = POST)
    public ModelAndView registerEmail(EmailRegistrationForm registrationForm) {
        OperationResult result = userProfileService.createRegistrationToken(registrationForm);
        if (result == SUCCESS) {
            return new ModelAndView("registration/view/registration_success");
        } else if (result == DUPLICATE){
            return new ModelAndView("registration/view/registration_duplicate");
        } else {
            throw new IllegalStateException("Registration was neither a success or duplicate");
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
