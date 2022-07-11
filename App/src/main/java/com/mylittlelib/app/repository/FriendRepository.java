package com.mylittlelib.app.repository;

import com.mylittlelib.app.model.Friend;
import com.mylittlelib.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend,Long> {
    Friend findByUserAndFriendUserIndex(User friend, Long userIndex);

    Friend findByUserAndFriendIndex(User user, Long userIndex);
    Friend findFriendByUserAndAndFriendUserIndex(User user, Long friendIndex);

    List<Friend> findFriendsByUser(User user);
}
