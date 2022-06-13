package com.mylittlelib.app.repository;

import com.mylittlelib.app.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
