package com.mylittlelib.app.controller;

import com.mylittlelib.app.DTO.CategoryDTO;
import com.mylittlelib.app.DTO.ResponseDTO;
import com.mylittlelib.app.model.Category;
import com.mylittlelib.app.model.User;
import com.mylittlelib.app.service.CategoryService;
import com.mylittlelib.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("category")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<?> findall(){
        List<Category> categories = categoryService.findAll();
        List<CategoryDTO> dtos =categories.stream().map(CategoryDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);

    }
    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody  CategoryDTO categoryDTO) {
        try {

            User getUser = userService.findbyId(categoryDTO.getUserId());
            Category category = Category.builder()
                    .categoryTitle(categoryDTO.getCategoryTitle())
                    .categoryDescription(categoryDTO.getCategoryDescription())
                    .user(getUser)
                    .build();
            Category registerCategory = categoryService.save(category);
            CategoryDTO responseCategoryDTO = CategoryDTO.builder()
                    .categoryIndex(registerCategory.getCategoryIndex())
                    .categoryDescription(registerCategory.getCategoryDescription())
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
            Category category = categoryService.findByTitle(categoryDTO.getCategoryTitle());
            CategoryDTO responseCategoryDTO = CategoryDTO.builder()
                    .categoryIndex(category.getCategoryIndex())
                    .categoryDescription(categoryDTO.getCategoryDescription())
                    .categoryTitle(category.getCategoryTitle())
                    .userId(category.getUser().getUserId())
                    .build();
            return ResponseEntity.ok(responseCategoryDTO);
        }catch (Exception e){
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCatgory(@RequestBody CategoryDTO categoryDTO){
        try {
            Category category = categoryService.updateCategory(categoryDTO);
            CategoryDTO responseCategoryDTO = CategoryDTO.builder()
                    .categoryIndex(category.getCategoryIndex())
                    .categoryTitle(category.getCategoryTitle())
                    .categoryDescription(categoryDTO.getCategoryDescription())
                    .userId(category.getUser().getUserId())
                    .build();
            return ResponseEntity.ok(responseCategoryDTO);
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }

    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCategory(@RequestBody CategoryDTO categoryDTO){
        try {
            List<Category> categories = categoryService.deleteCategory(categoryDTO);
            List<CategoryDTO> dtos =categories.stream().map(CategoryDTO::new).collect(Collectors.toList());
            return ResponseEntity.ok(dtos);
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }

    }
}
