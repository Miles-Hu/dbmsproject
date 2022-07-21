package com.example.demo.controllers;

import com.example.demo.models.Merchant;
import com.example.demo.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


/**
 * MerchantController
 */
@RequestMapping("/api/merchant")
@RestController
public class MerchantController {

    @Autowired
    MerchantRepository merchantRepository;


    /**
     * Register Merchant
     * @param merchant
     * @return
     */
    @PostMapping("")
    public ResponseEntity<Merchant> registerMerchant(@RequestBody Merchant merchant){
        try {
            Merchant merchantResponse = merchantRepository.save(merchant);
            return new ResponseEntity<>(merchantResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Delete Merchant
     * @param merchantId
     * @return
     */
    @DeleteMapping("")
    public ResponseEntity<Merchant> deleteMerchant(@RequestParam("merchantId") String merchantId){
        try {
            merchantRepository.deleteById(merchantId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Update Merchant
     * @param merchant
     * @return
     */
    @PutMapping("")
    public ResponseEntity<Merchant> updateMerchant(@RequestBody Merchant merchant){
        try {
            Merchant merchantResponse = merchantRepository.save(merchant);
            return new ResponseEntity<>(merchantResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get Merchant By Id
     * @param merchantId
     * @return
     */
    @GetMapping("")
    public ResponseEntity<Optional<Merchant>> getMerchantById(@RequestParam("merchantId") String merchantId){
        try {
            Optional<Merchant> merchantResponse = merchantRepository.findById(merchantId);
            return new ResponseEntity<>(merchantResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
