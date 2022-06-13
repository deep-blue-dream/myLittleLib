package com.mylittlelib.app.repository;

import com.mylittlelib.app.model.Profile;
import com.mylittlelib.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    boolean existsByUser(User user);

    Profile findByUser(User user);
}
