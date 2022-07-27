package com.example.demo.controllers;

import com.example.demo.models.*;
import com.example.demo.repository.ConcertsRepository;
import com.example.demo.repository.FeaturedRepository;
import com.example.demo.repository.MusicWorkRepository;
import com.example.demo.request.ConcertsDTO;
import com.example.demo.request.MusicWorkDTO;
import com.example.demo.request.MusicianDTO;
import com.example.demo.view.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author Miles
 * @create 2022-07-26 10:41 AM
 * @email miles.j.hoo@gmail.com
 **/

@RequestMapping()
@RestController
public class ConcertsController {

    @Autowired
    private FeaturedRepository featuredRepository;

    @Autowired
    private ConcertsRepository concertsRepository;

    @GetMapping("/list/concerts")
    public ResponseEntity<List<Concerts>> listConcerts(){
        List<Concerts> all = concertsRepository.findAll();
        return new ResponseEntity<List<Concerts>>().success(all);
    }

    @PostMapping("/add/concerts")
    @Transactional
    public ResponseEntity<Concerts> addConcerts(@RequestBody ConcertsDTO concertsDTO) {
        Concerts concerts = new Concerts();
        concerts.setTitle(concertsDTO.getTitle());
        concerts.setConcertType(concertsDTO.getConcertType());
        concertsRepository.save(concerts);
        for (MusicWorkDTO musicWork : concertsDTO.getMusicWorks()){
            Featured featured = new Featured();
            featured.setConcertTitle(concerts.getTitle());
            featured.setMusicTitle(musicWork.getTitle());
            featuredRepository.save(featured);
        }
        return new ResponseEntity<Concerts>().success(null);
    }
}
