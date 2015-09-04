package com.pabili.core.service.custom;

import com.pabili.commons.dto.EmailRegistrationForm;
import com.pabili.commons.dto.profile.UserProfileInfo;
import com.pabili.core.model.user.RegistrationToken;
import com.pabili.core.model.user.User;
import com.pabili.core.model.user.UserProfile;

/**
 * @author Mark Martinez, created Sep 4, 2015
 */
public interface UserProfileServiceCustom {

    RegistrationToken createRegistrationToken(EmailRegistrationForm registrationForm);
    UserProfile completeRegistration(User user);
    UserProfileInfo findInfoByUsername(String name);
    UserProfileInfo getPublicProfileByUsername(String username);

}
