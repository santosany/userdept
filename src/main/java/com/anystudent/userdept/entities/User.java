package com.anystudent.userdept.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long userId;
    @Column(name = "NAME")
    private String userName;
    @Column(name = "EMAIL")
    private String userEmail;
    @JoinColumn(name = "FK_IDDEPARTMENT")
    private Long userDepartment;

}
