package com.mylittlelib.app.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_index")
    private Long categoryIndex;


    @Column(name = "category_title")
    private String categoryTitle;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class) // student와 major의 관계는 다대일 (N:1)
    @JoinColumn(name = "user_index")
    private User user;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    private Set<Bookmark> bookmarkList = new HashSet<>();
}
