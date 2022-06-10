package com.mylittlelib.app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@Entity
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Category> categoryList = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Likes> likesList = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Friend> friendList = new HashSet<>();

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;



}
