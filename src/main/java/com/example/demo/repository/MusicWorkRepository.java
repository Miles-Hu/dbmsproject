package com.example.demo.repository;

import com.example.demo.models.CanPlayID;
import com.example.demo.models.MusicWork;
import com.example.demo.models.Musician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicWorkRepository extends JpaRepository<MusicWork, String> {
}
