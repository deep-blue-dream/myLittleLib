package com.mylittlelib.app.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpRequest;

@RequestMapping("like")
public class LikeController {


//    @PostMapping("/category/{categoryId}/likes")
//    public void likes(@PathVariable long categoryId, HttpServletRequest req, HttpServletResponse res){
//        String username = res.getHeader("username");
//
//        likesServiece.likes(categoryId);
//    }

//    @PostMapping("/category/{categoryId}/unlikes")
//    public void unLikes(@PathVariable long categoryId, Authentication authentication){
//        likesServiece.unLikes(categoryId, authentication.getName());
//    }

}
