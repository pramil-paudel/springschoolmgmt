package com.diginepal.schoolmgmt.auth.controller;


import com.diginepal.schoolmgmt.auth.dto.UserDto;
import com.diginepal.schoolmgmt.auth.model.Role;
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
    public User addQuestions(@RequestBody UserDto user) {
        User userToAdd = new User();
        userToAdd.setEmail(user.getEmail());
        userToAdd.setPassword(user.getPassword());
        userToAdd.setRole(Role.valueOf(user.getRole()));
        return userService.addNewUser(userToAdd);
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
