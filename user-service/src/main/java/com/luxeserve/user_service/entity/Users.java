package com.luxeserve.user_service.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "luxeserve_users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @Column(name = "ID")
    private String UserId;
    @Column(name = "NAME",length = 20)

    private String name;
    @Column(name = "EMAIL",length = 20)

    private String email;
    @Column(name = "ABOUT")

    private String about;

    @Transient
    private List<Rating> ratings=new ArrayList<>();

}
