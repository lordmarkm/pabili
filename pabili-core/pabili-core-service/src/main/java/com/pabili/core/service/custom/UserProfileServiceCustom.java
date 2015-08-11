package com.pabili.core.service.custom;

import com.pabili.commons.dto.EmailRegistrationForm;
import com.pabili.commons.operations.OperationResult;

public interface UserProfileServiceCustom {

    OperationResult createRegistrationToken(EmailRegistrationForm registrationForm);

}
