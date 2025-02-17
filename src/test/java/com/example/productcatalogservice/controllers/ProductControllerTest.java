package com.example.productcatalogservice.controllers;

import com.example.productcatalogservice.dtos.ProductDto;
import com.example.productcatalogservice.models.Product;
import com.example.productcatalogservice.services.IProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private IProductService productService;

    @Test
    void getProducts() {
    }

    @Test
    public void TestGetProductById_WithValidId_RunSuccessfully() {
        //arrange
        Long productId = 1L;
        when(productService.getProductById(productId)).thenReturn(
                new Product());
        //act

        ResponseEntity<ProductDto> response = productController.getProductById(productId);
        //assert

        assertNotNull(response);
        assertNotNull(response.getBody());


    }

    @Test
    void replaceProduct() {
    }

    @Test
    void getProductByIdWithCustomHeaders() {
    }

    @Test
    void createProduct() {
    }
}