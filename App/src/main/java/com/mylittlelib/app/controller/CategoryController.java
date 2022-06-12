package com.mylittlelib.app.controller;

import com.mylittlelib.app.DTO.CategoryDTO;
import com.mylittlelib.app.DTO.ResponseDTO;
import com.mylittlelib.app.DTO.UserDTO;
import com.mylittlelib.app.model.Category;
import com.mylittlelib.app.model.User;
import com.mylittlelib.app.service.CategoryService;
import com.mylittlelib.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.lang.annotation.Retention;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<?> save(@RequestBody  CategoryDTO categoryDTO) {
        try {

            User getUser = userService.findbyId(categoryDTO.getUserId());
            Category category = Category.builder()
                    .categoryTitle(categoryDTO.getCategoryTitle())
                    .user(getUser)
                    .build();
            Category registerCategory = categoryService.save(category);
            CategoryDTO responseCategoryDTO = CategoryDTO.builder()
                    .categoryIndex(registerCategory.getCategoryIndex())
                    .userId(registerCategory.getUser().getUserId())
                    .categoryTitle(registerCategory.getCategoryTitle())
                    .build();
            return ResponseEntity.ok(responseCategoryDTO);
        }catch (Exception e){
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }
    }
    @GetMapping("/search")
    public ResponseEntity<?> findByTitle(@RequestBody CategoryDTO categoryDTO){
        try{
            Category registerCategory = categoryService.findByTitle(categoryDTO);
            CategoryDTO responseCategoryDTO = CategoryDTO.builder()
                    .categoryIndex(registerCategory.getCategoryIndex())
                    .categoryTitle(registerCategory.getCategoryTitle())
                    .userId(registerCategory.getUser().getUserId())
                    .build();
            return ResponseEntity.ok(responseCategoryDTO);
        }catch (Exception e){
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }
    }
}
