package com.farukdegerli.kfkProjesi.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@Data

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "surname",nullable = false)
    private String surname;

    @Column(name = "legalId",nullable = false)
    private String legalId;

    @Column(name = "telNum")
    private String telephoneNumber;
    @Column(name = "address")
    private String address;

}
