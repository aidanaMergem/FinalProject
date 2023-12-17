package com.ead.finalproject.DTO;

import com.ead.finalproject.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private Set<Role> roles;

    // Constructors, getters, and setters
}
