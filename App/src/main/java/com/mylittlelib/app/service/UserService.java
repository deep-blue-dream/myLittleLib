package com.mylittlelib.app.service;

import com.mylittlelib.app.DTO.UserDTO;
import com.mylittlelib.app.model.User;
import com.mylittlelib.app.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        return userRepository.save(user);
    }
    private void userIdIsNull (String userId){
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

    public User findById(Long index){
        Optional<User> user = userRepository.findById(index);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }



    public User findbyId(String userId) {
        if(userRepository.findUserByUserId(userId) == null){
            throw new RuntimeException("invalid userId");
        }
        return userRepository.findUserByUserId(userId);
    }


    public User findByUserId(String userId){
        User user = userRepository.findUserByUserId(userId);
        if(user == null){
            log.error("유저 아이디가 잘못됨!");
            throw new RuntimeException("not match");
        }
        return user;
    }

    public User findbyEmail(String email) {
        if(userRepository.findUserByEmail(email) == null){
            throw new RuntimeException("invalid email");
        }
        return userRepository.findUserByEmail(email);
    }
}
