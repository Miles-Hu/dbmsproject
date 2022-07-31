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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Miles
 * @create 2022-07-26 10:41 AM
 * @email miles.j.hoo@gmail.com
 **/

@RequestMapping()
@RestController
public class ConcertsController {

    @Autowired
    private MusicWorkRepository musicWorkRepository;

    @Autowired
    private FeaturedRepository featuredRepository;

    @Autowired
    private ConcertsRepository concertsRepository;

    @GetMapping("/list/concerts")
    public ResponseEntity<List<ConcertsDTO>> listConcerts(){
        List<Concerts> all = concertsRepository.findAll();
        List<MusicWork> musicWorks = musicWorkRepository.findAll();
        List<Featured> featureds = featuredRepository.findAll();
        List<ConcertsDTO> concertsDTOS = new ArrayList<>();
        for (Concerts concerts : all) {
            List<String> musicTitles = featureds.stream().filter(e -> e.getConcertTitle().equals(concerts.getTitle())).map(e -> e.getMusicTitle()).collect(Collectors.toList());
            List<MusicWork> collect = musicWorks.stream().filter(e -> musicTitles.contains(e.getTitle())).collect(Collectors.toList());
            ConcertsDTO concertsDTO = new ConcertsDTO();
            concertsDTO.setTitle(concerts.getTitle());
            concertsDTO.setConcertType(concerts.getConcertType());
            concertsDTO.setMusicWorks(collect.stream().map(e -> {
                MusicWorkDTO musicWorkDTO = new MusicWorkDTO();
                musicWorkDTO.setTitle(e.getTitle());
                musicWorkDTO.setMusicType(e.getMusicType());
                return musicWorkDTO;
            }).collect(Collectors.toList()));
            concertsDTOS.add(concertsDTO);
        }
        return new ResponseEntity<List<ConcertsDTO>>().success(concertsDTOS);
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
