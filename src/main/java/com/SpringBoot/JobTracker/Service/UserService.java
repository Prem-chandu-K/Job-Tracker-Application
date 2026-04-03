package com.SpringBoot.JobTracker.Service;

import com.SpringBoot.JobTracker.Model.User;

public interface UserService {
    User findByUsername(String username);
    User save(User user);
}
