package com.mylittlelib.app.DTO;

import com.mylittlelib.app.model.Category;
import com.mylittlelib.app.model.Friend;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

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
    private boolean isSignedIn = false;

    private String categoryList;
    private Set<Friend> friendList;

}
