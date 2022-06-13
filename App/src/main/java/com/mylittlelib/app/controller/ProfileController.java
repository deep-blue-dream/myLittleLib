package com.mylittlelib.app.controller;

import com.mylittlelib.app.DTO.ProfileDTO;
import com.mylittlelib.app.DTO.ResponseDTO;
import com.mylittlelib.app.model.Profile;
import com.mylittlelib.app.model.User;
import com.mylittlelib.app.service.ProfileService;
import com.mylittlelib.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProfileDTO profileDTO){
        try{
            User user = userService.findById(profileDTO.getUserIndex());
            Profile profile = Profile.builder().imageUrl(profileDTO.getImageUrl()).user(user).build();
            Profile getProfile = profileService.save(profile);
            ProfileDTO getProfileDTO = ProfileDTO.builder()
                    .profileIndex(getProfile.getProfileIndex())
                    .userIndex(user.getUserIndex())
                    .imageUrl(getProfile.getImageUrl())
                    .build();
            return ResponseEntity.ok(getProfileDTO);
        } catch (Exception e){
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ProfileDTO profileDTO) {
        try {
            User user = userService.findById(profileDTO.getUserIndex());
            Profile profile = Profile.builder().imageUrl(profileDTO.getImageUrl()).user(user).build();
            Profile getProfile = profileService.update(profile);
            ProfileDTO getProfileDTO = ProfileDTO.builder()
                    .profileIndex(getProfile.getProfileIndex())
                    .userIndex(user.getUserIndex())
                    .imageUrl(getProfile.getImageUrl())
                    .build();
            return ResponseEntity.ok().body(getProfileDTO);
        } catch (Exception e){
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }

    }

}
