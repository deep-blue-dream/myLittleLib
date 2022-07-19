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

    @Column(name = "category_description")
    private String categoryDescription;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class) // student와 major의 관계는 다대일 (N:1)
    @JoinColumn(name = "user_index")
    private User user;

    @Builder.Default
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    private Set<Bookmark> bookmarkList = new HashSet<>();
    //비공개가 디폴트
    @Column(name = "authority")
    private int authority = 0 ;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
    private AuthorityGroup authorityGroup;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
//    private Set<Likes> likesList = new HashSet<>();

    @Override
    public String toString() {
        return "{ categoryTitle='" + categoryTitle + '\'' + '}';
    }
}
