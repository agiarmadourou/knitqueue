package com.knitqueue.service;

import com.knitqueue.entity.AppUser;

public interface AppUserService {
    AppUser save(AppUser theAppUser);
    AppUser findById(int theId);
}
