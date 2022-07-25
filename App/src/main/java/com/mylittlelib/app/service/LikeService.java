package com.mylittlelib.app.service;

import com.mylittlelib.app.model.Category;
import com.mylittlelib.app.model.Likes;
import com.mylittlelib.app.model.User;
import com.mylittlelib.app.repository.CategoryRepository;
import com.mylittlelib.app.repository.LikesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class LikeService {
    @Autowired
    private LikesRepository likesRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public Likes likes(Likes likes) {
        Category category = likes.getCategory();
        User user = likes.getUser();
        int likescount = category.getLikescount();
            //unlike 기능
        if(likesRepository.findByUserAndCategory(user, category) != null){
            likes  = likesRepository.findByUserAndCategory(user, category);
            log.info("좋이요 취소");
            likescount -= 1;
            category.setLikescount(likescount);
            categoryRepository.save(category);
            likesRepository.delete(likes);
            return likes;
        }
        likescount += 1;
        category.setLikescount(likescount);
        categoryRepository.save(category);
        likesRepository.save(likes);
        return likes;
    }
//
//    public void unLikes(long categoryId, String loginEmail) {
//        User user = userRepository.findUserByEmail((loginEmail));
//        likesRepository.unLikes(categoryId, user.getUserIndex());
//    }

}
