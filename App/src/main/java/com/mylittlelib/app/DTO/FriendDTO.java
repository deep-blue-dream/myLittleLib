package com.mylittlelib.app.DTO;

import com.mylittlelib.app.model.Friend;
import com.mylittlelib.app.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FriendDTO {
    private List<Long> friendsList;

    public FriendDTO(User user) {
        Set<Friend> userFriendsList = user.getFriendList();
        List<Long> friendIndexList = new ArrayList<>();

        for(Friend friend:userFriendsList) {
            friendIndexList.add(friend.getFriendUserIndex());
        }

        this.friendsList = friendIndexList;
    }
}
