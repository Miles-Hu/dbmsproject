package com.example.demo.repository;


import com.example.demo.models.ComposedOf;
import com.example.demo.models.ComposedOfID;
import com.example.demo.models.Concerts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcertsRepository extends JpaRepository<Concerts, String> {
}
