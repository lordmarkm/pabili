package com.pabili.core.service.custom;

import com.pabili.commons.dto.EmailRegistrationForm;
import com.pabili.commons.dto.profile.UserProfileInfo;
import com.pabili.core.model.user.RegistrationToken;
import com.pabili.core.model.user.User;
import com.pabili.core.model.user.UserProfile;

public interface UserProfileServiceCustom {

    RegistrationToken createRegistrationToken(EmailRegistrationForm registrationForm);
    UserProfile completeRegistration(User user);
    UserProfileInfo findInfoByUsername(String name);

}
