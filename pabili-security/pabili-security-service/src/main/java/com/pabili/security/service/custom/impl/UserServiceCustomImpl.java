/**
 * 
 */
package com.pabili.security.service.custom.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.pabili.commons.dto.CompleteRegistrationForm;
import com.pabili.commons.util.Roles;
import com.pabili.core.model.user.RegistrationToken;
import com.pabili.core.model.user.User;
import com.pabili.core.service.RegistrationTokenService;
import com.pabili.security.service.UserService;
import com.pabili.security.service.custom.UserServiceCustom;

/**
 * @author Mark Martinez, created Sep 2, 2015
 *
 */
public class UserServiceCustomImpl implements UserServiceCustom {

    @Autowired
    private UserService service;

    @Autowired
    private RegistrationTokenService registrationTokenService;

    @Override
    public User completeRegistration(RegistrationToken registrationToken, CompleteRegistrationForm registrationForm) {
        User user = new User();
        user.setUsername(registrationToken.getEmail());
        user.setPassword(registrationForm.getPassword());
        user.setAuthorities(Roles.ROLE_USER);

        registrationTokenService.delete(registrationToken);

        return service.save(user);
    }

}
