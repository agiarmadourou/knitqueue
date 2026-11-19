package com.knitqueue.knitqueue.service;

import com.knitqueue.knitqueue.entity.AppUser;
import com.knitqueue.knitqueue.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService{
    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserServiceImpl(AppUserRepository theAppUserRepository) {
        appUserRepository = theAppUserRepository;
    }

    @Override
    public AppUser save(AppUser theAppUser) {
        return appUserRepository.save(theAppUser);
    }

    @Override
    public AppUser findById(int theId) {
        return appUserRepository.findById(theId).
                orElseThrow(()->
                        new RuntimeException("User with id " + theId + " not found."));
    }
}
