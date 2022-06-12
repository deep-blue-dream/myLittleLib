package com.mylittlelib.app.service;

import com.mylittlelib.app.DTO.CategoryDTO;
import com.mylittlelib.app.model.Category;
import com.mylittlelib.app.repository.CategoryRepository;
import com.mylittlelib.app.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UserRepository userRepository;

    public Category save(Category category) {

        if(category.getCategoryTitle() == null ){
            throw new RuntimeException("Invalid arguments");
        }
        return categoryRepository.save(category);
    }
    public Category findByTitle(CategoryDTO categoryDTO) {
        Category findCategory = categoryRepository.findCategoryByCategoryTitle(categoryDTO.getCategoryTitle());
        if (findCategory == null) {
            log.error("failed");
            throw new RuntimeException("not find");
        }

        return findCategory;
    }
}
