package com.mylittlelib.app.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityGroupDTO {
    private Long groupIndex;
    private Long categoryIndex;
    private int groupLevel;

}
