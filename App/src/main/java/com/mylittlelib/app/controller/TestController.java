package com.mylittlelib.app.controller;

import com.mylittlelib.app.DTO.UserDTO;
import com.mylittlelib.app.model.User;
import com.mylittlelib.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test2")
public class TestController {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserService userService;

    @GetMapping
    public User home(HttpServletRequest req, HttpServletResponse res) {
        String username = res.getHeader("username");
        System.out.println(username);
        UserDTO userDTO = UserDTO.builder()
                .userIndex(null)
                .username(null)
                .password(null).build();
        User userEntity = userService.findByUsername(username);
        return userEntity;
    }

    @PostMapping("join")
    public User join(@RequestBody UserDTO userDTO) {
        userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        User newUser = User.builder()
                .username(userDTO.getUsername())
                .roles("ROLE_USER")
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .build();

        return userService.save(newUser);
    }
}

