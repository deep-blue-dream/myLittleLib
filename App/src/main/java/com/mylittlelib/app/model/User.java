package com.mylittlelib.app.model;

import lombok.*;
import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.util.*;

@Entity
@Builder
@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_index")
    private Long userIndex;

    @Column
    private String email;

    @Column
    private String username;

    @Column
    private String roles;

    @Column
    private String password;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Category> categoryList = new HashSet<>();

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
//    private Set<Likes> likesList = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Friend> friendList = new HashSet<>();

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;

    public String categoryTitletoString() {
        return "categoryList=" + categoryList.toString() ;
    }
    public String friendstoString(){
        return "friendList=" + friendList.toString();
    }

    public List<String> getRoleList() {
        if(this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }

        return new ArrayList<>();
    }

}
