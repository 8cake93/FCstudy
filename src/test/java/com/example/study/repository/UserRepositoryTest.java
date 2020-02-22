package com.example.study.repository;

import com.example.study.StudyApplication;
import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.User;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        String account = "Test01";
        String password = "test01";
        String status = "REGISTERED";
        String email = "ersu@gmail.com";
        String phoneNumber = "010-1010-1010";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "ersuServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);


        userRepository.save(user);
    }
    @Test
    @Transactional
    public void read(){
       User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1010-1010");

       if(user!=null){
           user.getOrderGroupList().stream().forEach(orderGroup -> {
               System.out.println("수령인" + orderGroup.getRevAddress());
               System.out.println(orderGroup.getId());
           });
       }

//        user.ifPresent(a->{
//            System.out.println(a.getPassword());
//        });
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
