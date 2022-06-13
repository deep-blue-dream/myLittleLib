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
        final String userId = user.getUserId();
        final String email = user.getEmail();
        final String password = user.getPassword();
        try{
            userIdIsNull(userId);
            emailIsNull(email);
            passwordIsNull(password);
            if(userRepository.existsUserByemail(email) || userRepository.existsUserByUserId(userId)){
                log.warn("Email or Id already exist >> {} {}", email, userId);
                throw new RuntimeException("Email or Id already exists");
            }
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
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
    private void userIdIsNull(String userId){
        if(userId == null || userId.equals("")){
            log.error("userId is null");
            throw  new RuntimeException("Invalid userId");
        }
    }
    private void emailIsNull(String email){
        if(email == null || email.equals("")){
            log.error("email is null");
            throw  new RuntimeException("Invalid email");
        }
    }
    private void passwordIsNull(String password){
        if(password == null || password.equals("")){
            log.error("password is null");
            throw  new RuntimeException("Invalid password");
        }
    }
}

