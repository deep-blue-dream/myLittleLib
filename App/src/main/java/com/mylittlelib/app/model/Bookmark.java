package com.mylittlelib.app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookmark_index")
    private Long bookmarkIndex;

    @Column(name = "bookmark_title")
    private String bookmarkTitle;

    @Column
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Category.class) // student와 major의 관계는 다대일 (N:1)
    @JoinColumn(name = "category_index")
    private Category category;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "bookmark")
    private Set<Likes> likesList = new HashSet<>();
}
