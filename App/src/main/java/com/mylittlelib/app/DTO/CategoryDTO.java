package com.mylittlelib.app.DTO;

import com.mylittlelib.app.model.Category;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private Long categoryIndex;
    private String categoryTitle;
    private String categoryDescription;
    private String userId;
    private String newCategoryTitle;
    private String newDescription;

    public CategoryDTO(Category category) {
        this.categoryIndex = category.getCategoryIndex();
        this.categoryTitle = category.getCategoryTitle();
        this.categoryDescription = category.getCategoryDescription();
        this.userId = category.getUser().getUserId();
    }

}
