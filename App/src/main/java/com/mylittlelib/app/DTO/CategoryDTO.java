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
    private String userId;
    private String newCategoryTitle;

    public CategoryDTO(Category category) {
        this.categoryIndex = category.getCategoryIndex();
        this.categoryTitle = category.getCategoryTitle();
        this.userId = category.getUser().getUserId();
    }

}
