package com.ead.finalproject.service;

import com.ead.finalproject.DTO.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> getAllUsers();

    UserDTO getUserByLogin(String login);

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(String login, UserDTO userDTO);

    void deleteUser(String login);

    Page<UserDTO> getAllUsers(Pageable pageable);

    Page<UserDTO> searchUsers(String keyword, Pageable pageable);
}
