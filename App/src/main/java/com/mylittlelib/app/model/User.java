package com.mylittlelib.app.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_index")
    private Long userIndex;

    @Column
    private String email;

    @Column(name = "user_id")
    private String userId;

    @Column
    private String password;

    @Column(name = "is_signin")
    private boolean isSignin;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Category> categoryList = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Likes> likesList = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Friend> friendList = new HashSet<>();

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;

    public String categoryTitletoString() {
        return "categoryList=" + categoryList.toString() ;
    }

}
