package com.mylittlelib.app.model;

import javax.persistence.*;

@Entity
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_index")
    private Long likeIndex;

    @ManyToOne(fetch = FetchType.LAZY) // student와 major의 관계는 다대일 (N:1)
    @JoinColumn(name = "user_index")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY) // student와 major의 관계는 다대일 (N:1)
    @JoinColumn(name = "bookmark_index")
    private Bookmark bookmark;
}
