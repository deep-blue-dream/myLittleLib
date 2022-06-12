package com.mylittlelib.app.service;

import com.mylittlelib.app.DTO.ProfileDTO;
import com.mylittlelib.app.model.Profile;
import com.mylittlelib.app.repository.ProfileRepository;
import com.mylittlelib.app.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProfileService {


    @Autowired
    public ProfileRepository profileRepository;

    @Autowired
    public UserRepository userRepository;

    public ProfileDTO save(Profile profile) {
        if (! userRepository.existsUserByUserId(profile.getUser().getUserId())){
            log.error("해당 유저가 존재하지 않습니다.");
            throw new RuntimeException("[ERROR] 해당 유저가 존재하지 않습니다.");
        }
        if (profileRepository.existsByUser(profile.getUser())){
            log.error("이미 프로필이 존재합니다.");
            throw new RuntimeException("[ERROR] 이미 프로필이 존재합니다.");
        }
        profileRepository.save(profile);
        ProfileDTO profileDTO = ProfileDTO
                .builder()
                .profileIndex(profile.getProfileIndex())
                .imageUrl(profile.getImageUrl())
                .userIndex(profile.getUser().getUserIndex())
                .build();

        return profileDTO;
    }


}
