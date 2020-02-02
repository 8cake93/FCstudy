package com.example.study.repository;

import com.example.study.StudyApplication;
import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        User user = new User();
        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-3333-3333");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");
        User newUser = userRepository.save(user);
        System.out.println(newUser);
    }
    @Test
    public void read(){
        Optional<User> user = userRepository.findById(3L);

        user.ifPresent(selectUser->{
            System.out.println(selectUser);

        });
    }
    @Test
    public void update(){
        Optional<User> user = userRepository.findById(3L);

        user.ifPresent(selectUser->{
            selectUser.setAccount("ersu");
            System.out.println(selectUser);
            userRepository.save(selectUser);
        });
    }
}
