package com.mylittlelib.app.controller;

import com.mylittlelib.app.DTO.FriendDTO;
import com.mylittlelib.app.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("friend")
public class FriendController {

    @Autowired
    private FriendService friendService;

    @GetMapping
    public FriendDTO save(@RequestParam("userId") String userId, @RequestParam("friendId") String friendId){
        return friendService.save(userId, friendId);
    }
}
