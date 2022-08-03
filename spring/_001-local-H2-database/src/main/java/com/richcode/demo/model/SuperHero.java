package com.richcode.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class SuperHero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String nickname;

}
