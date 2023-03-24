package com.org.unixam_backend.service;

import com.org.unixam_backend.model.User;
import com.org.unixam_backend.model.userRole;

import java.util.Set;

public interface UserService {
    public User createUser(User user, Set<userRole> userRoles) throws Exception;

    public User getUser(String username);

    public void deleteUser(Long Id);
}
