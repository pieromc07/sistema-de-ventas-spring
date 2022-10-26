package com.app.sellingsystem.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "name", unique = true, length = 20)
    private String name;

    @Column(name = "description")
    private String description;
}
