package com.example.demo.controller;


import com.example.demo.model.product;
import com.example.demo.service.productService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class productController {
        private final productService productService1;

        public productController(productService productService1) {
            this.productService1 = productService1;
        }

        @GetMapping("/product")
        public List<product> getProducts() {
            return productService1.getAllProducts();
        }

        @PostMapping("/addProduct")
        public @ResponseBody product addProduct(@RequestBody product p) {
            System.out.println(p);
            return productService1.addProduct(p);
        }

        @DeleteMapping("/product/{id}")
        public ResponseEntity<?> deleteProduct(@PathVariable int id) {
            return productService1.deleteProduct(id);
        }

        @PatchMapping("/updateProduct/{id}")  // Specify the path variable for product ID
        public @ResponseBody product updateProduct(@PathVariable int id, @RequestBody product p) {
            // Set the product ID in the product object
            p.setId_produit(id);
            return productService1.updateProduct(p);
        }

        @GetMapping("/product/{id}")
        public product getProductById(@PathVariable int id) {
            return productService1.getProductById(id);
        }
}
