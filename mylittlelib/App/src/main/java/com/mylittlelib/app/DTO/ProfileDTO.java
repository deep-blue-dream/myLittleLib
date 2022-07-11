package com.mylittlelib.app.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO {
    private Long profileIndex;
    private Long userIndex;
    private String imageUrl;
}
