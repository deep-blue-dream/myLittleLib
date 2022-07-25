package com.mylittlelib.app.repository;

import com.mylittlelib.app.model.Category;
import com.mylittlelib.app.model.Likes;
import com.mylittlelib.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends JpaRepository<Likes,Long> {
    //    Likes findLikesByCategoryAndUser(Category category, User user);
//
//    @Modifying
//    @Query(value = "INSERT INTO likes(category_index, user_index) VALUES(:category_index, :user_index)", nativeQuery = true)
//    void likes(long categoryId, long userId);
//
//    @Modifying
//    @Query(value = "DELETE FROM likes WHERE category_index = :categoryId AND user_index = :userId", nativeQuery = true)
//    void unLikes(long categoryId, long userId);
    Likes findByUserAndCategory(User user, Category category);

}
