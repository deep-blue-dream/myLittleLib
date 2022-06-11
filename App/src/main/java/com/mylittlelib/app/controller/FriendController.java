package com.mylittlelib.app.controller;

import com.mylittlelib.app.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("friend")
public class FriendController {

    @Autowired
    private FriendService friendService;
}
