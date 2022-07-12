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
        final String email = user.getEmail();
        try{
            emailIsNull(email);
            if(userRepository.existsUserByemail(email)){
                log.warn("Email already exist >> {}", email);
                throw new RuntimeException("Email or already exists");
            }
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
        return userRepository.save(user);
    }


    public User signin(UserDTO userDTO) {
        final String email = userDTO.getEmail();

        try {
            emailIsNull(email);
            if(userRepository.findUserByEmail(email)==null){
                throw new RuntimeException("login failed");
            }
            user = userRepository.findUserByEmail(email);
        } catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
        return userRepository.findUserByEmail(email);
    }

    private void emailIsNull(String email){
        if(email == null || email.equals("")){
            log.error("email is null");
            throw  new RuntimeException("Invalid email");
        }
    }

    public User findbyEmail(String email) {
        if(userRepository.findUserByEmail(email) == null){
            throw new RuntimeException("invalid email");
        }
        return userRepository.findUserByEmail(email);
    }
    public Long findbyFriendEmail(String email){
        if(userRepository.findUserByEmail(email) == null){
            throw new RuntimeException("Invalid FriendEmail");
        }
        return userRepository.findUserByEmail(email).getUserIndex();
    }
}
