package com.mylittlelib.app.service;

import com.mylittlelib.app.DTO.CategoryDTO;
import com.mylittlelib.app.model.Category;
import com.mylittlelib.app.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category save(Category category) {

        if(category.getCategoryTitle() == null  ){
            log.error("title is null");
            throw new RuntimeException("Invalid argument");
        }
        final String categoryTitle = category.getCategoryTitle();
        if(categoryRepository.findCategoryByCategoryTitle(categoryTitle) != null){
            log.warn("Category Title already exists {}", categoryTitle);
            throw new RuntimeException("Category Title already exists");
        }

        return categoryRepository.save(category);
    }
    public Category findByTitle(CategoryDTO categoryDTO) {

        Category findCategory = categoryRepository.findCategoryByCategoryTitle(categoryDTO.getCategoryTitle());
        if (findCategory == null) {
            log.error("failed");
            throw new RuntimeException("not found title");
        }

        return findCategory;
    }
    public Category updateCategory(CategoryDTO categoryDTO) {

        if(categoryDTO.getNewCategoryTitle() == null){
            log.error("newtitle is null");
            throw new RuntimeException("Invalid argument");
        }
        Category updateCategory = findByTitle(categoryDTO);
        updateCategory.setCategoryTitle(categoryDTO.getNewCategoryTitle());
        return categoryRepository.save(updateCategory);
    }
}
