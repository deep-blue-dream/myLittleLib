package com.mylittlelib.app.repository;

import com.mylittlelib.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsUserByemail(String email);

    User findUserByUserIdAndPassword(String userId, String password);
    User findUserByEmailAndPassword(String email, String password);

    boolean existsUserByUserId(String userId);

    User findUserByUserId(String userId);
    User findUserByEmail(String email);



}