package com.org.unixam_backend.service.Implements;


import com.org.unixam_backend.model.User;
import com.org.unixam_backend.model.userRole;
import com.org.unixam_backend.repository.RoleRepository;
import com.org.unixam_backend.repository.UserRepository;
import com.org.unixam_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public User createUser(User user, Set<userRole> userRoles) throws Exception {
        User local = this.userRepository.findByUsername(user.getUsername());

        if (local != null){
            throw new Exception("User already present");
        }else {
            for(userRole userR: userRoles){
                roleRepository.save(userR.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        return local;
    }

    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long Id) {
        this.userRepository.deleteById(Id);
    }
}