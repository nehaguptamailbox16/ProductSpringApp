package com.example.productcatalogservice.services;

import com.example.productcatalogservice.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> getProducts();

    Product getProductById(Long productId);

    Product createProduct(Product product);

    Product replaceProduct(Long productId, Product inputProduct);
}
