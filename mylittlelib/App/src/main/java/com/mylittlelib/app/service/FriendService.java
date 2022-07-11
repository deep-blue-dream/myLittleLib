package com.mylittlelib.app.service;

import com.mylittlelib.app.model.Friend;
import com.mylittlelib.app.model.User;
import com.mylittlelib.app.repository.FriendRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FriendService {

    @Autowired
    private FriendRepository friendRepository;


    public List<Friend> findAll(User user) {

        return friendRepository.findFriendsByUser(user);
    }

    public Friend save(User user, Friend friend) {
        if(friendRepository.findFriendByUserAndAndFriendUserIndex(user, friend.getFriendUserIndex()) != null){
            log.error("이미 친구추가한 사람 index : {}",friend.getFriendUserIndex() );
            throw new RuntimeException("Friend already exists");
        }
        if(user.getUserIndex() == friend.getFriendUserIndex()){
            log.error("{} == {}" ,user.getUserIndex(), friend.getFriendUserIndex());
            throw new RuntimeException("you enter your email in friendemail");
        }
        return friendRepository.save(friend);
    }

    public List<Friend> deletefriend(User user , Long friendindex) {
        if(friendRepository.findFriendByUserAndAndFriendUserIndex(user, friendindex) == null){
            log.error("둘은 친구가 아닌걸");
            throw new RuntimeException("no such friend");
        }
        Friend friend = friendRepository.findFriendByUserAndAndFriendUserIndex(user, friendindex);
        friendRepository.delete(friend);
        return friendRepository.findFriendsByUser(user);
    }


//
//    public FriendDTO save(String userId, String friendId) {
//        User user = userService.findByUserId(userId);
//        User friend = userService.findByUserId(friendId);
//
//        if (user == null || friend == null) {
//            log.error("친구 추가 실패. 본인, 친구의 아이디가 맞지 않음");
//            throw new RuntimeException("ERROR");
//        }
//        for (Friend oneFriend : user.getFriendList()) {
//            if (oneFriend.getFriendIndex() == friend.getUserIndex()) {
//                log.warn("이미 친구친구임");
//                Friend result = friendRepository.findByUserAndFriendIndex(user,friend.getUserIndex());
//                return new FriendDTO(result);
//            }
//        }
//
//        Friend result = Friend.builder()
//                    .user(user)
//                    .friendUserIndex(friend.getUserIndex())
//                    .build();
//
//        Friend result2 = Friend.builder()
//                    .user(friend)
//                    .friendUserIndex(user.getUserIndex())
//                    .build();
//
//        friendRepository.save(result);
//        friendRepository.save(result2);
//
//        FriendDTO friendDTO = FriendDTO
//                    .builder()
//                    .friendIndex(result.getFriendIndex())
//                    .friendUserIndex(friend.getUserIndex())
//                    .userIndex(user.getUserIndex())
//                    .build();
//        return friendDTO;
//    }
//
//    public boolean delete(String userId, String friendId) {
//        User user = userService.findByUserId(userId);
//        User friend = userService.findByUserId(friendId);
//        if (user == null || friend == null) {
//            log.error("삭제 실패. 본인, 친구의 아이디가 맞지 않음");
//            throw new RuntimeException("ERROR");
//        }
//        try {
//            Friend result = friendRepository.findByUserAndFriendUserIndex(user, friend.getUserIndex());
//            Friend result2 = friendRepository.findByUserAndFriendUserIndex(friend, user.getUserIndex());
//            friendRepository.delete(result);
//            friendRepository.delete(result2);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//
//
//    }
//


}
