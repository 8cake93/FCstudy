package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class CategoryRepositoryTest extends StudyApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void create(){
        String type = "타입";
        String title = "타이틀";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "임얼쑤";

        Category category = new Category();
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);

        categoryRepository.save(category);

    }
    @Test
    public void read(){
        Optional<Category> optionalCategory = categoryRepository.findByType("타입");

        optionalCategory.ifPresent(c->{
            System.out.println(c.getId()
                    + c.getTitle() + c.getType()
            );
        });
    }

}
