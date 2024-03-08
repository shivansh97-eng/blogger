package com.Blogger2.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name")
    private String name;

//    @ManyToMany(mappedBy = "roles")
//    private Set<User> users = new HashSet<>();

    // Constructors, getters, and setters
}
