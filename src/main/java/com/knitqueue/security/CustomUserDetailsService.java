package com.knitqueue.security;

import com.knitqueue.entity.AppUser;
import com.knitqueue.service.AppUserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/** Integrates user model with Spring Security */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final AppUserService appUserService;

    public CustomUserDetailsService(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser;

        // Email is used as the authentication identifier
        try {
        appUser = appUserService.findByEmail(username);
        } catch (NoSuchElementException e) {
            throw new UsernameNotFoundException("User not found", e);
        }

        // Map appUser to Spring Security UserDetails
        // Password verification is handled by PasswordEncoder
        return User.withUsername(appUser.getEmail())
                .password(appUser.getPasswordHash())
                .roles("USER")
                .build();
        }

}
