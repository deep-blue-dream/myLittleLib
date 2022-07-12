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
    private int authority;
    private String categoryTitle;
    private String categoryDescription;
    private String email;
    private List<BookmarkDTO> bookmarkDTOList;
    public CategoryDTO(Category category) {
        this.categoryIndex = category.getCategoryIndex();
        this.categoryTitle = category.getCategoryTitle();
        this.categoryDescription = category.getCategoryDescription();
        this.email = category.getUser().getEmail();
    }

}