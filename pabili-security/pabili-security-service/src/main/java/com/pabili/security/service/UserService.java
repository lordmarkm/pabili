package com.pabili.security.service;

import com.pabili.commons.service.BaseJpaService;
import com.pabili.core.model.user.User;
import com.pabili.security.service.custom.UserServiceCustom;

/**
 * @author Mark Martinez, created Sep 2, 2015
 */
public interface UserService extends UserServiceCustom, BaseJpaService<User> {

    User findByUsername(String username);

}
