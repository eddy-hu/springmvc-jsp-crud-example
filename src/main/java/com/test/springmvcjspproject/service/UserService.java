package com.test.springmvcjspproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.springmvcjspproject.model.User;
import com.test.springmvcjspproject.repository.UserRepository;



@Service("userService")
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
   
    }
    
    public void saveUser(User user) {
    	userRepository.save(user);
    }
    
    public User findByEmail(String email) {
    	return userRepository.findByEmail(email);
    }

    

    
    
}