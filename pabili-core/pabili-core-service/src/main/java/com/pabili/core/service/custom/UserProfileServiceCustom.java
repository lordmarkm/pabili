package com.pabili.core.service.custom;

import com.pabili.commons.dto.EmailRegistrationForm;
import com.pabili.core.model.user.RegistrationToken;

public interface UserProfileServiceCustom {

    RegistrationToken createRegistrationToken(EmailRegistrationForm registrationForm);

}
