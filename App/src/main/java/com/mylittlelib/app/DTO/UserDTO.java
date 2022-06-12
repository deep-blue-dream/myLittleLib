package com.mylittlelib.app.DTO;

import lombok.*;

import javax.persistence.Column;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long userIndex;
    private String email;
    private String userId;
    private String password;
    private String newPassword;
}
