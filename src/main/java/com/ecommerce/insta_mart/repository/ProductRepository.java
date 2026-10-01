package com.ecommerce.insta_mart.repository;

import com.ecommerce.insta_mart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findByName(String Name);
}
