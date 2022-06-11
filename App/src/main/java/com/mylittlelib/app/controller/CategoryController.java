package com.mylittlelib.app.controller;

import com.mylittlelib.app.DTO.CategoryDTO;
import com.mylittlelib.app.model.Category;
import com.mylittlelib.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public Category save(@RequestBody  CategoryDTO categoryDTO) {
        return categoryService.save(categoryDTO);
    }
}
