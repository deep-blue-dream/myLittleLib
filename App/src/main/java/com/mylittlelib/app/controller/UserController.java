package com.mylittlelib.app.controller;

import com.mylittlelib.app.DTO.UserDTO;
import com.mylittlelib.app.model.User;
import com.mylittlelib.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("/signin")
    public User signin(@RequestBody User user) {
        return userService.signin(user.getUserId(), user.getPassword());
    }

    @PostMapping("/update")
    public User update(@RequestBody UserDTO userDTO) {
        return userService.update(userDTO.getUserId(), userDTO.getPassword(), userDTO.getNewPassword());
    }
}
