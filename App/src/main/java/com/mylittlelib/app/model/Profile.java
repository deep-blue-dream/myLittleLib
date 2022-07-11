package com.mylittlelib.app.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    @Id
    @Column(name = "profile_index")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileIndex;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_index")
    private User user;

    @Column(name="image_url")
    private String imageUrl;
}