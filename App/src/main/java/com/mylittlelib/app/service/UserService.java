package com.mylittlelib.app.service;

import com.mylittlelib.app.DTO.UserDTO;
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
    User user;

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


    public User signin(UserDTO userDTO) {
        final String userId = userDTO.getUserId();
        final String password = userDTO.getPassword();

        try {
            userIdIsNull(userId);
            passwordIsNull(password);
            if(userRepository.findUserByUserIdAndPassword(userId, password) == null){
                throw new RuntimeException("login failed");
            }
            user = userRepository.findUserByUserId(userId);
            user.setSignin(true);
        } catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
        return userRepository.save(user);
    }


    public User update(UserDTO userDTO) {
        final String userId = userDTO.getUserId();
        final String password = userDTO.getPassword();
        final String newPassword = userDTO.getNewPassword();
        try {
            userIdIsNull(userId);
            passwordIsNull(password);
            passwordIsNull(newPassword);
            if(userRepository.findUserByUserId(userId) == null){
                throw new RuntimeException("Invalid userId");
            }
            if(!user.getPassword().equals(password)){
                log.error("failed");
                throw new RuntimeException("not match");
            }
//            user = userRepository.findUserByUserId(userId);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        User userr = userRepository.findUserByUserId(userId);
        userr.setPassword(newPassword);
        userr.setSignin(false);
        return userRepository.save(userr);
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

