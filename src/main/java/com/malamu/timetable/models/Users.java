package com.malamu.timetable.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity(name = "users_tbl")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String email;

    private String password;

    @ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Role role;
}
