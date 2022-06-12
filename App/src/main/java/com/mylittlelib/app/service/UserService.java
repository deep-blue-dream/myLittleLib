package com.mylittlelib.app.service;

import com.mylittlelib.app.model.User;
import com.mylittlelib.app.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        if(user == null || user.getUserId() == null || user.getEmail() == null || user.getPassword() == null){
            throw new RuntimeException("Invalid arguments");
        }
        final String email = user.getEmail();
        final String userId = user.getUserId();

        if(userRepository.existsUserByemail(email) || userRepository.existsUserByUserId(userId)){
            log.warn("Email or Id already exist >> {} {}", email, userId);
            throw new RuntimeException("Email or Id already exists");
        }
        return userRepository.save(user);
    }


    public User signin(String userId, String password) {
        User user = userRepository.findUserByUserIdAndPassword(userId, password);
        if(user == null){
            log.error("login failed");
        }
        return user;
    }

    public User update(String userId, String password, String newPassword) {
        User user = findbyId(userId);
        if(user == null || !user.getPassword().equals(password)){
                log.error("failed");
                throw new RuntimeException("not match");
        }
        user.setPassword(newPassword);
        return userRepository.save(user);
    }

    public User findbyId(String userId) {
        if(userRepository.findUserByUserId(userId) == null){
            throw new RuntimeException("invalid userId");
        }
        return userRepository.findUserByUserId(userId);
    }
}
