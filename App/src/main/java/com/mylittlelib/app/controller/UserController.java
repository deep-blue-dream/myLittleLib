package com.mylittlelib.app.controller;

import com.mylittlelib.app.DTO.ResponseDTO;
import com.mylittlelib.app.DTO.UserDTO;
import com.mylittlelib.app.model.User;
import com.mylittlelib.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> save(@RequestBody UserDTO userDTO) {
        try{
            User user = User.builder()
                    .userId(userDTO.getUserId())
                    .email(userDTO.getEmail())
                    .password(userDTO.getPassword())
                    .build();
            User registerUser = userService.save(user);
            UserDTO responseUserDTO = UserDTO.builder()
                    .userIndex(registerUser.getUserIndex())
                    .userId(registerUser.getUserId())
                    .email(registerUser.getEmail())
                    .password(registerUser.getPassword())
                    .build();
            return ResponseEntity.ok(responseUserDTO);
        }catch (Exception e){
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }
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
