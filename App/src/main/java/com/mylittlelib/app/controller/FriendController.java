package com.mylittlelib.app.controller;

import com.mylittlelib.app.DTO.CategoryDTO;
import com.mylittlelib.app.DTO.FriendDTO;
import com.mylittlelib.app.DTO.ResponseDTO;
import com.mylittlelib.app.model.Friend;
import com.mylittlelib.app.model.User;
import com.mylittlelib.app.service.FriendService;
import com.mylittlelib.app.service.UserService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("friend")
@CrossOrigin("*")
public class FriendController {

    @Autowired
    private FriendService friendService;

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<?> findAll(@RequestBody FriendDTO friendDTO){
        User getUser = userService.findbyEmail(friendDTO.getUserEmail());
        List<Friend> friendList = friendService.findAll(getUser);
        log.info("{}",getUser.getUserIndex());
        List<FriendDTO> dtos = friendList.stream().map(FriendDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
    //친구추가
    @PostMapping("addfriend")
    public ResponseEntity<?> save(@RequestBody FriendDTO friendDTO){
        try{
            User getUser = userService.findbyEmail(friendDTO.getUserEmail());
            Long getFriendIndex = userService.findbyFriendEmail(friendDTO.getFriendEmail());
            Friend friend = Friend.builder()
                    .user(getUser)
                    .friendUserIndex(getFriendIndex)
                    .build();
            Friend registerFriend = friendService.save(getUser,friend);
            FriendDTO responseFriendDTO = FriendDTO.builder()
                    .friendIndex(registerFriend.getFriendIndex())
                    .userIndex(registerFriend.getUser().getUserIndex())
                    .userEmail(registerFriend.getUser().getEmail())
                    .friendUserIndex(registerFriend.getFriendUserIndex())
                    .friendEmail(friendDTO.getFriendEmail())
                    .build();
            return ResponseEntity.ok(responseFriendDTO);
        }catch (Exception e){
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }
    }



    // 친삭
    @DeleteMapping()
    public ResponseEntity<?> delete(@RequestBody FriendDTO friendDTO){
        try {
            User getUser = userService.findbyEmail(friendDTO.getUserEmail());
            Long getFriendIndex = userService.findbyFriendEmail(friendDTO.getFriendEmail());
            List<Friend> friends = friendService.deletefriend(getUser, getFriendIndex);
            List<FriendDTO> dtos = friends.stream().map(FriendDTO::new).collect(Collectors.toList());
            return ResponseEntity.ok(dtos);
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }
}
