package com.luxeserve.user_service.entity;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
@JsonPropertyOrder({"userId", "name", "email", "about", "ratings"})
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
