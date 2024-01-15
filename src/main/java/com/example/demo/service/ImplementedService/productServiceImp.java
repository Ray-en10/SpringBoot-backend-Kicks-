package com.example.demo.service.ImplementedService;


import com.example.demo.model.Category;
import com.example.demo.model.product;
import com.example.demo.service.productService;
import com.example.demo.repository.productRepository;
import com.example.demo.repository.categoryRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class productServiceImp implements productService {

    private final productRepository productRepo;
    private final categoryRepository categoryRepo;
    private final EntityManager entityManager;


    public productServiceImp(productRepository product, categoryRepository categoryRepo, EntityManager entityManager) {
        this.productRepo = product;
        this.categoryRepo = categoryRepo;
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public product addProduct(product p) {
        Category category = categoryRepo.findById(p.getCategory().getId_category())
                .orElseThrow(() -> new NoSuchElementException("Category not found"));
        category = entityManager.merge(category);
        p.setCategory(category);
        return productRepo.save(p);
    }

    @Override
    public ResponseEntity<?> deleteProduct(int id){
        productRepo.deleteById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Product removed successfully with id: " + id);
        System.out.println("Product removed successfully with id: " +response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public product updateProduct (product p){
        return productRepo.save(p);
    }

    @Override
    public product getProductById(int id){

        return productRepo.findById(id).orElse(null);
    }

    @Override
    public List<product> getAllProducts(){
        return productRepo.findAll();
    }

}