package com.example.demo.repository;

import com.example.demo.models.Musician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Miles
 * @create 2022-07-23 4:35 PM
 * @email miles.j.hoo@gmail.com
 **/

@Repository
public interface MusicianRepository extends JpaRepository<Musician, Integer> {
}
