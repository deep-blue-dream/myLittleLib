package com.mylittlelib.app.service;

import com.mylittlelib.app.DTO.BookmarkDTO;
import com.mylittlelib.app.DTO.CategoryDTO;
import com.mylittlelib.app.model.Bookmark;
import com.mylittlelib.app.model.Category;
import com.mylittlelib.app.model.User;
import com.mylittlelib.app.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    private Category category;


    public Category save(Category category, User user) {
        final String categoryTitle = category.getCategoryTitle();

        try{
            titleIsNull(categoryTitle);
            if(categoryRepository.findCategoryByCategoryTitleAndUser(categoryTitle, user) != null){
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
        } catch (NullPointerException e) {
            throw new RuntimeException("Not found title");
        }
        return category;
    }
    public Category findByIndex(Long index){
        try {
            category = categoryRepository.findCategoryByCategoryIndex(index);
        } catch (NullPointerException e) {
            throw new RuntimeException("Not found index");
        }
        return category;
    }
    public Category updateCategory(CategoryDTO categoryDTO) {


        try{
            category = categoryRepository.findCategoryByCategoryIndex(categoryDTO.getCategoryIndex());
            category.setAuthority(categoryDTO.getAuthority());
            category.setCategoryTitle(categoryDTO.getCategoryTitle());
            category.setCategoryDescription(categoryDTO.getCategoryDescription());
        }catch (NullPointerException e) {

            throw new RuntimeException(e.getMessage());
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
        return categoryRepository.save(category);




    }
    public List<Category> deleteCategory(CategoryDTO categoryDTO) {
        String title = categoryDTO.getCategoryTitle();
        try {
            titleIsNull(title);
            category = categoryRepository.findCategoryByCategoryTitle(title);
            categoryRepository.delete(category);
        } catch (NullPointerException e) {
            throw new RuntimeException("Not found title");
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
        return categoryRepository.findAll();

    }

    private void titleIsNull(String title){
        if(title == null || title.equals("")){
            log.error("categorytitle is null");
            throw  new RuntimeException("Invalid argument");
        }
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
    //나의 카테고리 조회
    public List<CategoryDTO> totalInfo(User user) {
        List<Category> categoryList = categoryRepository.findByUser(user);
        List<CategoryDTO> categoryDTOList = setcategorylist(categoryList);
        return categoryDTOList;
    }
    //다른 사람의 카테고리까지 조회 -> 본인 카테고리 제외하고 조회해야함 일단 내꺼 포함 조회
    public List<CategoryDTO> totalInfo() {
        List<Category> categories = categoryRepository.findByAuthority(1);
        List<CategoryDTO> categoryDTOList = setcategorylist(categories);
        return categoryDTOList;
    }

    //검색하는 유저의 공개 카테고리 조회
    public List<CategoryDTO> infobyuser(User user) {
        List<Category> categories = categoryRepository.findByAuthorityAndUser(1, user);
        List<CategoryDTO> categoryDTOList = setcategorylist(categories);
        return categoryDTOList;
    }
    private List<CategoryDTO> setcategorylist(List<Category> categories){
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (Category category:categories) {

            CategoryDTO categoryDTO = CategoryDTO
                    .builder().categoryDescription(category.getCategoryDescription())
                    .authority(category.getAuthority())
                    .categoryIndex(category.getCategoryIndex())
                    .categoryTitle(category.getCategoryTitle())
                    .bookmarkDTOList(new ArrayList<>())
                    .build();
            List<BookmarkDTO> bookmarkDTOList = categoryDTO.getBookmarkDTOList();
            for (Bookmark bookmark: category.getBookmarkList()) {
                BookmarkDTO bookmarkDTO = BookmarkDTO
                        .builder()
                        .bookmarkIndex(bookmark.getBookmarkIndex())
                        .bookmarkTitle(bookmark.getBookmarkTitle())
                        .description(bookmark.getDescription())
                        .bookmarkUrl(bookmark.getBookmarkurl())
                        .build();
                bookmarkDTOList.add(bookmarkDTO);
                System.out.println(category.getCategoryTitle()+"ㄷㄷ "+bookmark.getBookmarkTitle());
            }
            categoryDTOList.add(categoryDTO);
        }
        return categoryDTOList;
    }
}