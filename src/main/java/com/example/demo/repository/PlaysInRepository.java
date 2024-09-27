package com.example.demo.repository;


import com.example.demo.models.ComposedOf;
import com.example.demo.models.ComposedOfID;
import com.example.demo.models.PlaysIn;
import com.example.demo.models.PlaysInID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaysInRepository extends JpaRepository<PlaysIn, PlaysInID> {
}
