package com.example.demo.repository;

import com.example.demo.models.CanPlay;
import com.example.demo.models.CanPlayID;
import com.example.demo.models.Instruments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanPlayRepository extends JpaRepository<CanPlay, CanPlayID> {
}
