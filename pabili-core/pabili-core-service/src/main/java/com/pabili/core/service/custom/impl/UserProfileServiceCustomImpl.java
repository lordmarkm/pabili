package com.pabili.core.service.custom.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pabili.commons.dto.EmailRegistrationForm;
import com.pabili.commons.dto.profile.UserProfileInfo;
import com.pabili.commons.service.MappingService;
import com.pabili.core.model.user.BuyerProfile;
import com.pabili.core.model.user.GopherProfile;
import com.pabili.core.model.user.RegistrationToken;
import com.pabili.core.model.user.User;
import com.pabili.core.model.user.UserProfile;
import com.pabili.core.service.RegistrationTokenService;
import com.pabili.core.service.UserProfileService;
import com.pabili.core.service.custom.UserProfileServiceCustom;

@Transactional
public class UserProfileServiceCustomImpl extends MappingService<UserProfile, UserProfileInfo> implements UserProfileServiceCustom {

    @Autowired
    private UserProfileService service;

    @Autowired
    private RegistrationTokenService registrationTokenService;

    @Override
    public RegistrationToken createRegistrationToken(EmailRegistrationForm registrationForm) {
        String email = registrationForm.getEmail();
        if (null != service.findByEmail(email)) {
            return null;
        }

        RegistrationToken registrationToken = registrationTokenService.findByEmail(email);
        if (null != registrationToken) {
            registrationToken.setToken(generateToken());
        } else {
            registrationToken = new RegistrationToken();
            registrationToken.setEmail(email);
            registrationToken.setToken(generateToken());
            registrationTokenService.save(registrationToken);
        }

        return registrationToken;
    }

    private String generateToken() {
        return UUID.randomUUID().toString();
    }

    @Override
    public UserProfile completeRegistration(User user) {
        UserProfile userProfile = new UserProfile();
        userProfile.setBuyerProfile(new BuyerProfile());
        userProfile.setGopherProfile(new GopherProfile());
        userProfile.setEmail(user.getUsername());
        userProfile.setUser(user);

        return service.save(userProfile);
    }

    @Override
    public UserProfileInfo findInfoByUsername(String name) {
        return toDto(service.findByUserUsername(name));
    }

    @Override
    public UserProfileInfo getPublicProfileByUsername(String username) {
        return findInfoByUsername(username);
    }
}
