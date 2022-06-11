package com.mylittlelib.app.service;

import com.mylittlelib.app.DTO.CategoryDTO;
import com.mylittlelib.app.model.Category;
import com.mylittlelib.app.repository.CategoryRepository;
import com.mylittlelib.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UserRepository userRepository;
    public Category save(CategoryDTO categoryDTO) {
        Category category = new Category();

        if(userRepository.existsUserByUserId(categoryDTO.getUserId())){
            category.setCategoryTitle(categoryDTO.getCategoryTitle());
            category.setUser(userRepository.findUserByUserId(categoryDTO.getUserId()));
        }
        return categoryRepository.save(category);
    }
}
