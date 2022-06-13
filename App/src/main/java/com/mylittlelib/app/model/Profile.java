package com.mylittlelib.app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Profile {

    @Id
    @Column(name = "profile_index")
    private Long profileIndex;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_index")
    private User user;

    @Column(name="image_url")
    private String imageUrl;
}