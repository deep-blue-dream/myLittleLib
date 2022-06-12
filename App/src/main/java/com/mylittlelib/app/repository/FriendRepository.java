package com.mylittlelib.app.repository;

import com.mylittlelib.app.model.Friend;
import com.mylittlelib.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend,Long> {
    Friend findByUserAndFriendIndex(User user, Long userIndex);
}
