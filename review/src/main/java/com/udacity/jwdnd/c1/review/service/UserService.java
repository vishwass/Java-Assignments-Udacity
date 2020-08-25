package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.mapper.UserMapper;
import com.udacity.jwdnd.c1.review.model.User;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserService {
    private HashService hashService;
    private UserMapper userMapper;

    public UserService(HashService hashService,UserMapper userMapper) {
        this.hashService = hashService;
        this.userMapper = userMapper;
    }

    public boolean isUsernameAvailable(User user){
        return userMapper.findUserByUsername(user.getUsername()) == null;
    }

    public Integer createUser(User user){
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(user.getPassword(),encodedSalt);
        return this.userMapper.createUser(new User(null, user.getUsername(), encodedSalt, hashedPassword, user.getFirstname(), user.getLastname()));

    }

    public User getUser(String username){
        return  userMapper.findUserByUsername(username);
    }

}
