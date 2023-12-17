package com.ead.finalproject.repository;

import com.ead.finalproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, String> {


    List<User> findByFirstName(String firstName);

    List<User> findByLastName(String lastName);

    Optional<User> findByLogin(String login);

    void deleteByLogin(String login);
}




