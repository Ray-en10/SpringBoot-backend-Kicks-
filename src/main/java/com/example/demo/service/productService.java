package com.example.demo.service;
import com.example.demo.model.product;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public interface productService {
    product addProduct(product p);

    ResponseEntity<?> deleteProduct(int id);

    product updateProduct(product p);

    product getProductById(int id);

    List<product> getAllProducts();
}
