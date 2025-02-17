package com.example.productcatalogservice.repositories;

import com.example.productcatalogservice.models.Category;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository repository;

    @Test
    @Transactional
    public void testFetchType(){
        Category category = repository.findById(1L).get();


        }


}