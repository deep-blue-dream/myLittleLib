package com.mylittlelib.app.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityGuest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_index")
    private Long authorityIndex;

    @Column(name = "guest_index")
    private Long guestIndex;

    @ManyToOne
    @JoinColumn(name = "group_index")
    private AuthorityGroup authorityGroup;
}
