package com.mylittlelib.app.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LikeDTO {
    private Long likeindex;
    private Long userIndex;
    private String userEmail;
    private Long categoryIndex;


}
