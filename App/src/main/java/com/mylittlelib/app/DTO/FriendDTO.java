package com.mylittlelib.app.DTO;

import com.mylittlelib.app.model.Friend;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FriendDTO {
    private Long friendIndex;
    private Long userIndex;
    private Long friendUserIndex;

    public FriendDTO(Friend friend){
        this.friendIndex = friend.getFriendIndex();
        this.userIndex = friend.getUser().getUserIndex();
        this.friendUserIndex = friend.getFriendUserIndex();

    }
}
