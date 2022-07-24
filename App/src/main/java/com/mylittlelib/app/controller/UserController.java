package com.mylittlelib.app.controller;

import com.mylittlelib.app.DTO.ResponseDTO;
import com.mylittlelib.app.DTO.UserDTO;
import com.mylittlelib.app.model.User;
import com.mylittlelib.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserController {


    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> save(@RequestBody UserDTO userDTO) {
        try{
            User user = User.builder()
                    .email(userDTO.getEmail())
                    .build();
            User registerUser = userService.save(user);
            UserDTO responseUserDTO = UserDTO.builder()
                    .userIndex(registerUser.getUserIndex())
                    .email(registerUser.getEmail())
                    .build();
            return ResponseEntity.ok(responseUserDTO);
        }catch (Exception e){
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }
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


    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody UserDTO userDTO) {
        try{
            User user = userService.signin(userDTO);
            UserDTO responseUserDTO = UserDTO.builder()
                    .isSignedIn(true)
                    .userIndex(user.getUserIndex())
                    .email(user.getEmail())
                    .categoryList(user.categoryTitletoString())
                    .build();
            return ResponseEntity.ok(responseUserDTO);
        }catch (Exception e){
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }
    }
    @PostMapping("findUser")
    public ResponseEntity<?> findByUserId(@RequestBody UserDTO userDTO){
        try{
            User user = userService.findbyEmail(userDTO.getEmail());
            UserDTO responseUserDTO = UserDTO.builder()
                    .userIndex(user.getUserIndex())
                    .email(user.getEmail())
                    .categoryList(user.categoryTitletoString())
                    .friendsList(user.friendstoString())
                    .build();
            return ResponseEntity.ok(responseUserDTO);
        }catch (Exception e){
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }
    }


}