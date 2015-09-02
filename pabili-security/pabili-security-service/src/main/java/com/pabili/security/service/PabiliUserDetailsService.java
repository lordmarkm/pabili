package com.pabili.security.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

/**
 * @author Mark Martinez, created Sep 2, 2015
 */
@Service
public class PabiliUserDetailsService  implements UserDetailsService {

    private static Logger LOG = LoggerFactory.getLogger(PabiliUserDetailsService.class);

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        LOG.info("Authenticating user. username={}", username);

        com.pabili.core.model.user.User user = userService.findByUsername(username);
        if(null == user) {
            throw new UsernameNotFoundException("User " + username + " not found.");
        }

        List<SimpleGrantedAuthority> authorities = Lists.newArrayList();
        String[] authStrings = user.getAuthorities().split(", ");
        for(String authString : authStrings) {
            authorities.add(new SimpleGrantedAuthority(authString));
        }

        UserDetails ud = new User(user.getUsername(), user.getPassword(), authorities);
        LOG.info("Authenticated. user details={}", ud);
        return ud;
    }

}
