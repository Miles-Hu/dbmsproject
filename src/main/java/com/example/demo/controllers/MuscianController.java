package com.example.demo.controllers;


import com.example.demo.models.Musician;
import com.example.demo.repository.MusicianRepository;
import com.example.demo.view.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * MuscianController
 */
@RequestMapping()
@RestController
public class MuscianController {

    @Autowired
    private MusicianRepository musicianRepository;

    /**
     *
     * @return
     */
    @GetMapping("/list/musician")
    public ResponseEntity<List<Musician>> listMusician(){
        List<Musician> all = musicianRepository.findAll();
        return new ResponseEntity<List<Musician>>().success(all);
    }

}
