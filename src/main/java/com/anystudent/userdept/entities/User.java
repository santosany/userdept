package com.anystudent.userdept.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @ManyToOne
    @JoinColumn(name = "FK_IDDEPARTMENT")
    private Department userDepartment;

}
