package com.ead.finalproject.config;

import com.ead.finalproject.model.Role;
import com.ead.finalproject.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    public List<User> initialUsers() {
        return List.of(
                new User("aidana", "aidana123", "Aidana", "Mergembaeva", new HashSet<>(), Collections.singleton(Role.USER)),
                new User("madina", "mad1109", "Madina", "Sat",new HashSet<>(), Collections.singleton(Role.USER)),
                new User("marlen", "mar0552", "Marlen", "Kemaluly",new HashSet<>(), Collections.singleton(Role.USER)),
                new User("jasmin", "2811jas", "Jasmin", "Sauken",new HashSet<>(), Collections.singleton(Role.USER)),
                new User("admin123", "adminPass", "Aidana", "Mergembaeva", new HashSet<>(),Collections.singleton(Role.ADMIN))
        );
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
