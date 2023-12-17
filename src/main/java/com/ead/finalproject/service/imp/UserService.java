//package com.ead.finalproject.service.imp;
//
//import com.ead.finalproject.model.Role;
//import com.ead.finalproject.model.User;
//import lombok.NonNull;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class UserService {
//
//    private final List<User> users;
//
//    public UserService() {
//        this.users = List.of(
//                new User("aidana", "aidana123", "Aidana", "Mergembaeva", new HashSet<>(), Collections.singleton(Role.USER)),
//                new User("madina", "mad1109", "Madina", "Sat",new HashSet<>(), Collections.singleton(Role.USER)),
//                new User("marlen", "mar0552", "Marlen", "Kemaluly",new HashSet<>(), Collections.singleton(Role.USER)),
//                new User("jasmin", "2811jas", "Jasmin", "Sauken",new HashSet<>(), Collections.singleton(Role.USER)),
//                new User("admin123", "adminPass", "Aidana", "Mergembaeva", new HashSet<>(),Collections.singleton(Role.ADMIN))
//        );
//    }
//
//    public Optional<User> getByLogin(@NonNull String login) {
//        return users.stream()
//                .filter(user -> login.equals(user.getLogin()))
//                .findFirst();
//    }
//
//}