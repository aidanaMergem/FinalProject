package com.ead.finalproject.service.imp;

import com.ead.finalproject.DTO.UserDTO;
import com.ead.finalproject.model.Role;
import com.ead.finalproject.model.User;
import com.ead.finalproject.repository.UserRepo;
import com.ead.finalproject.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service

public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepo.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserByLogin(String login) {
        Optional<User> userOptional = userRepo.findByLogin(login);
        return userOptional.map(user -> modelMapper.map(user, UserDTO.class)).orElse(null);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        user.setRoles(Set.of(Role.USER)); // Assuming default role is USER
        User savedUser = userRepo.save(user);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public UserDTO updateUser(String login, UserDTO userDTO) {
        Optional<User> userOptional = userRepo.findByLogin(login);
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            // Update user properties
            existingUser.setFirstName(userDTO.getFirstName());
            existingUser.setLastName(userDTO.getLastName());
            // Other properties update as needed

            User updatedUser = userRepo.save(existingUser);
            return modelMapper.map(updatedUser, UserDTO.class);
        }
        return null; // User not found
    }

    @Override
    public void deleteUser(String login) {
        userRepo.deleteByLogin(login);
    }

    @Override
    public Page<UserDTO> getAllUsers(Pageable pageable) {
        // Implement paginated retrieval if needed
        // Example: userRepo.findAll(pageable);
        return null;
    }

    @Override
    public Page<UserDTO> searchUsers(String keyword, Pageable pageable) {
        // Implement user search logic if needed
        // Example: userRepo.findByFirstNameContainingOrLastNameContaining(keyword, keyword, pageable);
        return null;
    }

    public Optional<User> getByLogin(@NonNull String login) {
        List<User> users = userRepo.findAll();
        return users.stream()
                .filter(user -> login.equals(user.getLogin()))
                .findFirst();
    }
}
