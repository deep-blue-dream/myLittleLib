package com.mylittlelib.app.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityGuestDTO {
    private Long authorityIndex;
    private Long guestIndex;
    private Long groupIndex;

}
