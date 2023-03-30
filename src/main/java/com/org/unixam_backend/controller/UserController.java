package com.org.unixam_backend.controller;

import com.org.unixam_backend.model.User;
import com.org.unixam_backend.model.Role;
import com.org.unixam_backend.model.UserRole;

import com.org.unixam_backend.repository.UserRepository;
import com.org.unixam_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserService userService;

    private UserRepository userRepository;

    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
        user.setProfile("default.png");

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        Role role = new Role();
        role.setRoleName("ADMIN");
        Set<UserRole> userRoleSet=new HashSet<>();
        UserRole userRole=new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);
        user.setUserRoles(userRoleSet);
        userRoleSet.add(userRole);
        return  this.userService.createUser(user,userRoleSet);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username)
    {
        System.out.println(username);

        return this.userService.getUser(username);
    }

    @DeleteMapping("/{Id}")
    public void deleteUser(@PathVariable("Id") Long id)
    {
        System.out.println(id);
        this.userService.deleteUser(id);
    }
}
