package com.diginepal.schoolmgmt.auth.controller;


import com.diginepal.schoolmgmt.auth.model.User;
import com.diginepal.schoolmgmt.auth.repository.UserRepository;
import com.diginepal.schoolmgmt.auth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/auth")
public class DigiUserManagementController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @PostMapping(value = "add/users")
    public User addQuestions(@RequestBody User user) {
        return userService.addNewUser(user);
    }

    @GetMapping(value = "/userdetails")
    public User getUserDetails(Principal principal){
        User existingUser = userRepository.findByEmail(principal.getName());

        if (existingUser==null){
            throw new UsernameNotFoundException("User for principal not found!");
        }else {
            return existingUser;
        }
    }

}
