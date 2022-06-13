package com.mylittlelib.app.repository;

import com.mylittlelib.app.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend,Long> {
}
