package com.mylittlelib.app.service;

import com.mylittlelib.app.DTO.CategoryDTO;
import com.mylittlelib.app.model.Category;
import com.mylittlelib.app.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    private Category category;

    public Category save(Category category) {
        final String categoryTitle = category.getCategoryTitle();

        try{
            titleIsNull(categoryTitle);
            if(categoryRepository.findCategoryByCategoryTitle(categoryTitle) != null){
                log.warn("Category Title already exists {}", categoryTitle);
                throw new RuntimeException("Category Title already exists");
            }
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }

        return categoryRepository.save(category);
    }
    public Category findByTitle(String title) {

        try {
            category = categoryRepository.findCategoryByCategoryTitle(title);
            return category;
        } catch (NullPointerException e) {
            throw new RuntimeException("Not found title");
        }
    }
    public Category updateCategory(CategoryDTO categoryDTO) {

        String title = categoryDTO.getCategoryTitle();
        try{
            titleIsNull(categoryDTO.getCategoryTitle());
            category = categoryRepository.findCategoryByCategoryTitle(title);
            category.setCategoryTitle(categoryDTO.getNewCategoryTitle());
        }catch (NullPointerException e) {
            throw new RuntimeException("Not found title");
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
        return categoryRepository.save(category);




    }
    public List<Category> deleteCategory(CategoryDTO categoryDTO) {
        String title = categoryDTO.getCategoryTitle();
        try {
            titleIsNull(categoryDTO.getCategoryTitle());
            category = categoryRepository.findCategoryByCategoryTitle(title);
            category.setCategoryTitle(categoryDTO.getNewCategoryTitle());
            categoryRepository.delete(category);
            return categoryRepository.findAll();
        } catch (NullPointerException e) {
            throw new RuntimeException("Not found title");
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    private void titleIsNull(String title){
        if(title == null || title.equals("")){
            log.error("title is null");
            throw  new RuntimeException("Invalid argument");
        }
    }
}
