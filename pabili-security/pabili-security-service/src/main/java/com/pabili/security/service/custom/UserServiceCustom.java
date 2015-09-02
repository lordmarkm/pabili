package com.pabili.security.service.custom;

import com.pabili.commons.dto.CompleteRegistrationForm;
import com.pabili.core.model.user.RegistrationToken;
import com.pabili.core.model.user.User;

/**
 * @author Mark Martinez, created Sep 2, 2015
 */
public interface UserServiceCustom {

    /**
     * @param registrationToken
     * @param registrationForm
     * @return
     */
    User completeRegistration(RegistrationToken registrationToken, CompleteRegistrationForm registrationForm);

}
