package com.mylittlelib.app.service;

import com.mylittlelib.app.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendService {

    @Autowired
    private FriendRepository friendRepository;
}
