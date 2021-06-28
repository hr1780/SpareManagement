package com.cts.sparemanagement_regestraion.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Data
@Entity
public class UserDetailsEntity {
    @Id
    @Column(unique = true)
    private String userName;
    @NotBlank(message = "password is Required")
    private String password;
    @NotBlank(message = "Address is Required")
    private String address;
    @NotBlank(message = "State is Required")
    private String state;
    @NotBlank(message = "Country is Required")
    private String country;
    @NotBlank(message = "Contact Number is Required")
    private String contactNo;
    private Date dateOfBirth;
    @NotBlank(message = "Role is Requried")
    private String role;
}
