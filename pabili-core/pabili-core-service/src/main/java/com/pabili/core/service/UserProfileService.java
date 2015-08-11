package com.pabili.core.service;

import com.pabili.core.model.user.UserProfile;
import com.pabili.core.service.base.BaseJpaService;
import com.pabili.core.service.custom.UserProfileServiceCustom;

public interface UserProfileService extends UserProfileServiceCustom, BaseJpaService<UserProfile> {

    UserProfile findByEmail(String email);

}
