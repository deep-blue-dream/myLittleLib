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
    public ResponseEntity<?> signin(@RequestBody UserDTO userDTO) {
        try{
            User user = userService.signin(userDTO);
            UserDTO responseUserDTO = UserDTO.builder()
                    .userIndex(user.getUserIndex())
                    .userId(user.getUserId())
                    .password(user.getPassword())
                    .email(user.getEmail())
                    .categoryList(user.categoryTitletoString())
                    .build();
            return ResponseEntity.ok(responseUserDTO);
        }catch (Exception e){
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody UserDTO userDTO) {
        try{
            User user = userService.update(userDTO);
            UserDTO responseUserDTO = UserDTO.builder()
                    .userIndex(user.getUserIndex())
                    .userId(user.getUserId())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .categoryList(user.categoryTitletoString())
                    .build();
            return ResponseEntity.ok(responseUserDTO);
        }catch (Exception e){
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }
    }
}
