package com.mylittlelib.app.DTO;

import com.mylittlelib.app.model.Category;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private Long categoryIndex;
    private String categoryTitle;
    private String categoryDescription;
    private String email;
    private String newCategoryTitle;
    private String newDescription;
    private List<BookmarkDTO> bookmarkDTOList;
    public CategoryDTO(Category category) {
        this.categoryIndex = category.getCategoryIndex();
        this.categoryTitle = category.getCategoryTitle();
        this.categoryDescription = category.getCategoryDescription();
        this.email = category.getUser().getEmail();
    }

}