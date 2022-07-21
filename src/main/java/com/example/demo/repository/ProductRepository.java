package com.example.demo.repository;

import com.example.demo.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByMerchantId(String merchantId);
}
