package com.example.productcatalogservice.controllers;


import com.example.productcatalogservice.dtos.CategoryDto;
import com.example.productcatalogservice.dtos.ProductDto;
import com.example.productcatalogservice.models.Category;
import com.example.productcatalogservice.models.Product;
import com.example.productcatalogservice.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/products")
   public List<ProductDto> getProducts() {
        List<ProductDto> productDto = new ArrayList<>();
        List<Product> response = productService.getProducts();
        if (response == null) {
            return null;
        }

        for (Product product : response) {
            productDto.add(from(product));
        }
        return productDto;
    }

    @GetMapping("/products/{id}")
    public ProductDto getProductById(@PathVariable("id") Long productId) {
//        ProductDto productDto = new ProductDto();
//       productDto.setId(productId);
//        productDto.setName("Iphone");
//        return productDto;

      Product product =   productService.getProductById(productId);
      return from(product);
    }

    @PutMapping("/products/{id}")
    public ProductDto replaceProduct(@PathVariable("id") Long id,  @RequestBody ProductDto productDto) {
        Product inputProduct = from(productDto);
        Product response = productService.replaceProduct(id, inputProduct);
        return from(response);
    }


    @GetMapping("/products/custom/{id}")
    public ResponseEntity<ProductDto> getProductByIdWithCustomHeaders(@PathVariable("id") Long productId) {

        Product product =   productService.getProductById(productId);
        ProductDto productDto = from(product);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Called By", "Frontend");  // custom header
        return new ResponseEntity<>(productDto,headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @PostMapping("/products")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        Product product = productService.createProduct(from(productDto));
        return from(product);
    }

    private ProductDto from(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setPrice(product.getPrice());
        if(product.getCategory() != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setName(product.getCategory().getName());
            categoryDto.setId(product.getCategory().getId());
            categoryDto.setDescription(product.getCategory().getDescription());
            productDto.setCategory(categoryDto);
        }
        return productDto;
    }

    private Product from(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageUrl());
        product.setPrice(productDto.getPrice());

        if(productDto.getCategory() != null) {
            Category category = new Category();
            category.setId(productDto.getCategory().getId());
            category.setName(productDto.getCategory().getName());
//            categoryDto.setId(product.getCategory().getId());
//            categoryDto.setDescription(product.getCategory().getDescription());
            product.setCategory(category);
        }
        return product;
    }



}
