package com.mylittlelib.app.service;

import com.mylittlelib.app.DTO.ProfileDTO;
import com.mylittlelib.app.model.Profile;
import com.mylittlelib.app.model.User;
import com.mylittlelib.app.repository.ProfileRepository;
import com.mylittlelib.app.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ProfileService {


    @Autowired
    public ProfileRepository profileRepository;

    @Autowired
    public UserRepository userRepository;

    public Profile save(Profile profile) {
        if (profile.getUser() == null){
            log.error("해당 유저가 존재하지 않음.");
            throw new RuntimeException("[ERROR] 해당 유저가 존재하지 않습니다.");
        }

        if (profileRepository.existsByUser(profile.getUser())){
            log.error("이미 프로필이 존재합니다.");
            throw new RuntimeException("[ERROR] 이미 프로필이 존재합니다.");
        }

        return profileRepository.save(profile);
    }


    public Profile update(Profile profile) {
        if (profile.getUser() == null){
            log.error("해당 유저가 존재하지 않음.");
            throw new RuntimeException("[ERROR] 해당 유저가 존재하지 않습니다.");
        }

        if (!profileRepository.existsByUser(profile.getUser())){
            log.error("프로필이 존재하지 않습니다.");
            throw new RuntimeException("[ERROR] 프로필이 존재하지 않습니다.");
        }
        Profile getProfile = profileRepository.findByUser(profile.getUser());
        getProfile.setImageUrl(profile.getImageUrl());
        getProfile.setUser(profile.getUser());
        return profileRepository.save(getProfile);
    }

    public boolean delete(Long userIndex) {
        try{
            Optional<User> user = userRepository.findById(userIndex);
            User getUser = user.get();
            if (getUser == null){
                log.error("해당 유저가 존재하지 않음.");
                throw new RuntimeException("[ERROR] 해당 유저가 존재하지 않습니다.");
            }
            Profile getProfile = profileRepository.findByUser(getUser);
            if (!profileRepository.existsByUser(getUser)){
                log.error("프로필이 존재하지 않습니다.");
                throw new RuntimeException("[ERROR] 프로필이 존재하지 않습니다.");
            }


            System.out.println(getProfile.getProfileIndex());
            System.out.println(getProfile.getImageUrl());
            getUser.setProfile(null);
            profileRepository.delete(getProfile);
            userRepository.save(getUser);
            return true;
        } catch (Exception e){
            return false;
        }

    }
}
