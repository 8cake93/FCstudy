package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.AdminUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class AdminUserRepositoryTest extends StudyApplicationTests {

    @Autowired
    AdminUserRepository adminUserRepository;

    @Test
    public void create(){
        AdminUser adminUSer = new AdminUser();
        adminUSer.setAccount("AdminUser01");
        adminUSer.setPassword("AdminUSer01");
        adminUSer.setStatus("RE");
        adminUSer.setRole("PARTNER");
        adminUSer.setCreatedAt(LocalDateTime.now());
        adminUSer.setCreatedBy("Admin server");

        adminUserRepository.save(adminUSer);
    }
}
