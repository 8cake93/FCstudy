package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Optional;

public class ItemRepositoryTest extends StudyApplicationTests {
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){
        Item item = new Item();
        item.setStatus("노트북1");
        item.setName("림얼쑤");
        item.setTitle("얼쑤");
        item.setContent("이이잉");
        item.setPrice(900000);
        item.setBrandName("애플");
        item.setRegisteredAt(LocalDateTime.now());
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy("IMS");
        item.setPartnerId(1L);

        itemRepository.save(item);
    }
    @Test
    public void read(){
        Long id = 1L;

        Optional<Item> item = itemRepository.findById(id);
        item.ifPresent(i->{
            System.out.println(i);
        });

    }
}
