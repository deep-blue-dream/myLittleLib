package com.mylittlelib.app.service;

import com.mylittlelib.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProfileService {

    @Autowired
    private UserRepository userRepository;
}
