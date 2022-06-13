package com.mylittlelib.app.controller;

import com.mylittlelib.app.DTO.FriendDTO;
import com.mylittlelib.app.DTO.ResponseDTO;
import com.mylittlelib.app.model.Friend;
import com.mylittlelib.app.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("friend")
public class FriendController {

    @Autowired
    private FriendService friendService;

    // 친추
    @GetMapping
    public FriendDTO save(@RequestParam("userId") String userId, @RequestParam("friendId") String friendId){
        return friendService.save(userId, friendId);
    }

    // 친삭
    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam("userId") String userId,@RequestParam("friendId") String friendId){
        try {
            boolean flag = friendService.delete(userId,friendId);
            return ResponseEntity.ok().body(flag);
        } catch (Exception e){
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }
}
