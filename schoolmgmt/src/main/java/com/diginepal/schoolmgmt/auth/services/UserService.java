package com.diginepal.schoolmgmt.auth.services;



import com.diginepal.schoolmgmt.auth.model.User;
import com.diginepal.schoolmgmt.auth.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        log.debug("Loading user details for username: {}", username);
        UserDetails userDetails = userRepository.findByEmail(username);
        if (userDetails == null) {
            log.error("User not found!");
            throw new UsernameNotFoundException("Sorry !! You do not have an access.");
        }
        return userDetails;
    }

    public User addNewUser(User user){
        log.debug("Loading user details for username: {}", user.getEmail());
        UserDetails userDetails = userRepository.findByEmail(user.getEmail());
        if (userDetails == null) {
            log.error("New user is being added.");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }else{
            throw new RuntimeException("Duplicate user name is not allowed !! ");
        }
    }
}
