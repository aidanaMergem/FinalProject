package com.ead.finalproject.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "user")  // Specify the table name
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String login;

    private String password;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "user")
    private Set<Booking> bookings;


    private Set<Role> roles;

    // Getters and setters

}
