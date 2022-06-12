package com.mylittlelib.app.service;

import com.mylittlelib.app.DTO.FriendDTO;
import com.mylittlelib.app.model.Friend;
import com.mylittlelib.app.model.User;
import com.mylittlelib.app.repository.FriendRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FriendService {

    @Autowired
    private FriendRepository friendRepository;

    @Autowired
    private UserService userService;



    public FriendDTO save(String userId, String friendId) {
        User user = userService.findByUserId(userId);
        User friend = userService.findByUserId(friendId);

        if (user == null || friend == null) {
            log.error("친구 추가 실패. 본인, 친구의 아이디가 맞지 않음");
            throw new RuntimeException("ERROR");
        }
        for (Friend oneFriend : user.getFriendList()) {
            if (oneFriend.getFriendIndex() == friend.getUserIndex()) {
                log.warn("이미 친구친구임");
                Friend result = friendRepository.findByUserAndFriendIndex(user,friend.getUserIndex());
                return new FriendDTO(result);
            }
        }

        Friend result = Friend.builder()
                    .user(user)
                    .friendUserIndex(friend.getUserIndex())
                    .build();

        Friend result2 = Friend.builder()
                    .user(friend)
                    .friendUserIndex(user.getUserIndex())
                    .build();

        friendRepository.save(result);
        friendRepository.save(result2);

        FriendDTO friendDTO = FriendDTO
                    .builder()
                    .friendIndex(result.getFriendIndex())
                    .friendUserIndex(friend.getUserIndex())
                    .userIndex(user.getUserIndex())
                    .build();
        return friendDTO;
    }
}
