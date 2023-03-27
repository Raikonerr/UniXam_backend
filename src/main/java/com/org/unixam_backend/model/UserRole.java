package com.org.unixam_backend.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userRoleId;


    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne
    private Role role;


}
