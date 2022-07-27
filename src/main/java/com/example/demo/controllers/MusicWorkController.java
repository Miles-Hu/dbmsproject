package com.example.demo.controllers;

/**
 * @author Miles
 * @create 2022-07-26 10:07 AM
 * @email miles.j.hoo@gmail.com
 **/


import com.example.demo.models.*;
import com.example.demo.repository.*;
import com.example.demo.request.MusicWorkDTO;
import com.example.demo.request.MusicianDTO;
import com.example.demo.view.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * MusicWorkController
 */
@RequestMapping()
@RestController
public class MusicWorkController {

    @Autowired
    private MusicWorkRepository musicWorkRepository;

    @Autowired
    private InstrumentsRepository instrumentsRepository;

    @Autowired
    private MusicianRepository musicianRepository;

    @Autowired
    private PlaysInRepository playsInRepository;

    @Autowired
    private ComposedOfRepository composedOfRepository;

    /**
     *
     * @return
     */
    @GetMapping("/list/music_work")
    public ResponseEntity<List<MusicWork>> listMusicWork(@RequestParam List<Integer> musicTypes){
        List<MusicWork> all = musicWorkRepository.findAll();
        List<MusicWork> collect = all.stream().filter(e -> musicTypes.contains(e.getMusicType())).collect(Collectors.toList());
        return new ResponseEntity<List<MusicWork>>().success(collect);
    }


    @PostMapping("/add/music_work")
    @Transactional
    public ResponseEntity<MusicWork> addMusicWork(@RequestBody MusicWorkDTO musicWorkDTO) {
        MusicWork musicWork = new MusicWork();
        musicWork.setTitle(musicWorkDTO.getTitle());
        musicWork.setMusicType(musicWorkDTO.getMusicType());
        musicWorkRepository.save(musicWork);
        for (Instruments instruments : musicWorkDTO.getInstruments()){
            Optional<Instruments> byId = instrumentsRepository.findById(instruments.getName());
            if (!byId.isPresent()) {
                instrumentsRepository.save(instruments);
            }
            ComposedOf composedOf = new ComposedOf();
            composedOf.setMusicTitle(musicWorkDTO.getTitle());
            composedOf.setInstrumentName(instruments.getName());
            composedOfRepository.save(composedOf);
        }
        for (MusicianDTO musician : musicWorkDTO.getMusicians()) {
            PlaysIn playsIn = new PlaysIn();
            playsIn.setMusicianId(musician.getMusicianId());
            playsIn.setMusicTitle(musicWorkDTO.getTitle());
            playsInRepository.save(playsIn);
        }
        return new ResponseEntity<MusicWork>().success(null);
    }
}
