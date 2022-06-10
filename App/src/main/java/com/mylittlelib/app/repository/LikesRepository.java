package com.mylittlelib.app.repository;

import com.mylittlelib.app.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<Likes,Long> {
}
