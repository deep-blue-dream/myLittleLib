package com.mylittlelib.app.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="authority_index")
    private Long authorityIndex;

    @ManyToOne
    @JoinColumn(name = "user_index")
    private User user;

    @OneToOne
    @JoinColumn(name = "category_index")
    private Category category;

    @Column(name = "level")
    private Long level;


}
