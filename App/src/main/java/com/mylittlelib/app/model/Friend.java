package com.mylittlelib.app.model;

import javax.persistence.*;

@Entity
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "friend_index")
    private Long friendIndex;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class) // student와 major의 관계는 다대일 (N:1)
    @JoinColumn(name = "user_index")
    private User user;

    @Column(name = "friend_user_index")
    private Long friendUserIndex;
}
