package com.ecommerce.insta_mart.controller;

import com.ecommerce.insta_mart.entity.Product;
import com.ecommerce.insta_mart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> searchProduct(@PathVariable Long id){
        Optional<Product> pro = productRepository.findById(id);
        if(pro.isPresent()){
            return ResponseEntity.ok(pro.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/products")
    public Product updateProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
    }

    @GetMapping("/search-product")
    public ResponseEntity<?> searchByName(@RequestParam String name){
        Optional<Product> searchN = productRepository.findByName(name);
        if(searchN.isPresent()){
            return ResponseEntity.ok(searchN.get());
        }
        return ResponseEntity.notFound().build();
    }

}
