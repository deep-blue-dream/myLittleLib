package com.mylittlelib.app.controller;

import com.mylittlelib.app.DTO.LikeDTO;
import com.mylittlelib.app.DTO.ResponseDTO;
import com.mylittlelib.app.model.Category;
import com.mylittlelib.app.model.Likes;
import com.mylittlelib.app.model.User;
import com.mylittlelib.app.service.CategoryService;
import com.mylittlelib.app.service.LikeService;
import com.mylittlelib.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("api/like")
@CrossOrigin("*")
public class LikeController {

    @Autowired
    LikeService likeService;
    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;
    @PostMapping()
    public ResponseEntity<?> likes(@RequestBody LikeDTO likeDTO){
        try {
            User getUser = userService.findbyEmail(likeDTO.getUserEmail());
            Category getCategory = categoryService.findByIndex(likeDTO.getCategoryIndex());
            Likes likes = Likes.builder()
                    .category(getCategory)
                    .user(getUser)
                    .build();
            Likes regiteredLikes = likeService.likes(likes);
            LikeDTO responseLikeDTO = LikeDTO.builder()
                    .categoryIndex(regiteredLikes.getCategory().getCategoryIndex())
                    .userIndex(regiteredLikes.getUser().getUserIndex())
                    .userEmail(regiteredLikes.getUser().getEmail())
                    .likeindex(regiteredLikes.getLikeIndex())
                    .build();
            return ResponseEntity.ok(responseLikeDTO);
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }
    }

//    @PostMapping("/category/{categoryId}/unlikes")
//    public void unLikes(@PathVariable long categoryId, Authentication authentication){
//        likesServiece.unLikes(categoryId, authentication.getName());
//    }

}
