package com.pabili.core.service;

import com.pabili.commons.service.BaseJpaService;
import com.pabili.core.model.user.UserProfile;
import com.pabili.core.service.custom.UserProfileServiceCustom;

/**
 * @author Mark Martinez, created Sep 4, 2015
 */
public interface UserProfileService extends UserProfileServiceCustom, BaseJpaService<UserProfile> {

    UserProfile findByEmail(String email);
    UserProfile findByUserUsername(String username);

}
