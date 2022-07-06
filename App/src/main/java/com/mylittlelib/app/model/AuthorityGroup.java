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
public class AuthorityGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_index")
    private Long groupIndex;

    @Column(name = "group_level")
    private Long groupLevel;

    @OneToOne
    @JoinColumn(name = "category_index")
    private Category category;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "authorityGroup")
    private Set<AuthorityGuest> friendList = new HashSet<>();

}
