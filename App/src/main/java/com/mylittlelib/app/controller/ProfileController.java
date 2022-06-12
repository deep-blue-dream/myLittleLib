package com.mylittlelib.app.controller;

import com.mylittlelib.app.DTO.ProfileDTO;
import com.mylittlelib.app.model.Profile;
import com.mylittlelib.app.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @PostMapping
    public ProfileDTO save(@RequestBody Profile profile){
        return profileService.save(profile);
    }

}
