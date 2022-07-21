package com.example.demo.controllers;

import com.example.demo.models.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * ProductController
 */
@RequestMapping("/api/product")
@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    /**
     * Add Product
     * @param product
     * @return
     */
    @PostMapping("")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        try {
            Product productResponse = productRepository.save(product);
            return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Delete product
     * @param productId
     * @return
     */
    @DeleteMapping("")
    public ResponseEntity<Product> deleteProduct(@RequestParam("merchantId") String productId) {
        try {
            productRepository.deleteById(productId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Update Product
     * @param product
     * @return
     */
    @PutMapping("")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        try {
            Product productResponse = productRepository.save(product);
            return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Add List of products
     * @param merchantId
     * @param products
     * @return
     */
    @PostMapping("/addAll")
    public ResponseEntity<List<Product>> addProducts(@RequestParam("merchantId") String merchantId, @RequestBody List<Product> products) {
        try {
            products.stream().forEach(o -> o.setMerchantId(merchantId));
            List<Product> productsResponse = productRepository.saveAll(products);
            return new ResponseEntity<>(productsResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get Products By MerchantId
     * @param merchantId
     * @return
     */
    @GetMapping("")
    public ResponseEntity<List<Product>> getProductsByMerchantId(@RequestParam("merchantId") String merchantId){
        try {
            List<Product> productsResponse = productRepository.findByMerchantId(merchantId);
            return new ResponseEntity<>(productsResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get Products price stats By MerchantId
     * @param merchantId
     * @return
     */
    @GetMapping("/priceStats")
    public ResponseEntity<IntSummaryStatistics> getProductsPriceStatsByMerchantId(@RequestParam("merchantId") String merchantId){
        try {
            List<Product> productsResponse = productRepository.findByMerchantId(merchantId);
            IntSummaryStatistics intSummaryStatistics = productsResponse.stream().mapToInt(p->p.getPrice()).summaryStatistics();
            return new ResponseEntity<>(intSummaryStatistics, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}