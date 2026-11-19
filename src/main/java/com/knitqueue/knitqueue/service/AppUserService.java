package com.knitqueue.knitqueue.service;

import com.knitqueue.knitqueue.entity.AppUser;

public interface AppUserService {
    AppUser save(AppUser theAppUser);
    AppUser findById(int theId);
}
