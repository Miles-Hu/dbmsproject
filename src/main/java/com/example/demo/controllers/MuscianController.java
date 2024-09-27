package com.example.demo.controllers;


import com.example.demo.models.CanPlay;
import com.example.demo.models.Instruments;
import com.example.demo.models.Musician;
import com.example.demo.repository.CanPlayRepository;
import com.example.demo.repository.InstrumentsRepository;
import com.example.demo.repository.MusicianRepository;
import com.example.demo.request.MusicianDTO;
import com.example.demo.view.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * MuscianController
 */
@RequestMapping()
@RestController
public class MuscianController {

    @Autowired
    private MusicianRepository musicianRepository;

    @Autowired
    private InstrumentsRepository instrumentsRepository;

    @Autowired
    private CanPlayRepository canPlayRepository;

    /**
     *
     * @return
     */
    @GetMapping("/list/musician")
    public ResponseEntity<List<Musician>> listMusician(){
        List<Musician> all = musicianRepository.findAll();
        return new ResponseEntity<List<Musician>>().success(all);
    }

    @GetMapping("/list/instruments")
    public ResponseEntity<List<Instruments>> listInstruments(){
        List<Instruments> all = instrumentsRepository.findAll();
        return new ResponseEntity<List<Instruments>>().success(all);
    }

    @PostMapping("/add/musician")
    @Transactional
    public ResponseEntity<Musician> addMusician(@RequestBody MusicianDTO musicianDTO) {
        Musician musician = new Musician();
        musician.setFname(musicianDTO.getFname());
        musician.setMinit(musicianDTO.getMinit());
        musician.setLname(musicianDTO.getLname());
        Musician save = musicianRepository.save(musician);
        for (Instruments instruments : musicianDTO.getInstruments()){
            Optional<Instruments> byId = instrumentsRepository.findById(instruments.getName());
            if (!byId.isPresent()) {
                instrumentsRepository.save(instruments);
            }
            CanPlay canPlay = new CanPlay();
            canPlay.setMusicianId(save.getMusicianId());
            canPlay.setInstrumentName(instruments.getName());
            canPlayRepository.save(canPlay);
        }
        return new ResponseEntity<Musician>().success(null);
    }



}
