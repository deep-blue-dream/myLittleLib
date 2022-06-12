package com.mylittlelib.app.DTO;

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

}
