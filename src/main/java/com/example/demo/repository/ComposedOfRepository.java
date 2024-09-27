package com.example.demo.repository;


import com.example.demo.models.CanPlay;
import com.example.demo.models.ComposedOf;
import com.example.demo.models.ComposedOfID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComposedOfRepository extends JpaRepository<ComposedOf, ComposedOfID> {
}
