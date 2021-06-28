package com.cts.sparemanagement_order.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class UserDetailsEntity {

    @Id
    @Column(unique = true)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String contactNo;
    @Column(nullable = false)
    private Date dateOfBirth;
    @Column(nullable = false)
    private String role;
}
