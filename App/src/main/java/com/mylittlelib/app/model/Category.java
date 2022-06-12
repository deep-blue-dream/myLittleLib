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
