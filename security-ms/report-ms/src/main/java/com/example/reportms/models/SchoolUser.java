package com.example.reportms.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class SchoolUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String username;
    private String password;
    private String email;


    //to manage the relationship
    @ManyToMany(fetch = EAGER)
    //set or initialize role to an array list
    private Collection<Role>roles = new ArrayList<>();


}
