package com.example.demo.repository;

import com.example.demo.models.Featured;
import com.example.demo.models.FeaturedID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeaturedRepository extends JpaRepository<Featured, FeaturedID> {
}
