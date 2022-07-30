package com.example.demo.controllers;

import com.example.demo.models.Events;
import com.example.demo.models.Musician;
import com.example.demo.repository.EventsRepository;
import com.example.demo.request.EventsDTO;
import com.example.demo.request.MusicianDTO;
import com.example.demo.view.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Miles
 * @create 2022-07-26 2:47 PM
 * @email miles.j.hoo@gmail.com
 **/

@RequestMapping()
@RestController
public class EventsController {
    @Autowired
    private EventsRepository eventRepository;

    @GetMapping("/list/event")
    public ResponseEntity<List<EventsDTO>> listEvent(){
        List<Events> all = eventRepository.findAll();
        List<EventsDTO> collect = all.stream().map(e -> {
            EventsDTO eventsDTO = new EventsDTO();
            eventsDTO.setDatetime(e.getDatetime().getTime());
            eventsDTO.setPlace(e.getPlace());
            eventsDTO.setConcertTitle(e.getConcertTitle());
            eventsDTO.setTitle(e.getTitle());
            eventsDTO.setEventId(e.getEventId());
            return eventsDTO;
        }).collect(Collectors.toList());
        return new ResponseEntity<List<EventsDTO>>().success(collect);
    }

    @PostMapping("/add/event")
    public ResponseEntity<EventsDTO> addEvent(@RequestBody EventsDTO eventsDTO) {
        Events events = new Events();
        events.setConcertTitle(eventsDTO.getConcertTitle());
        events.setDatetime(new Date(eventsDTO.getDatetime()));
        events.setPlace(eventsDTO.getPlace());
        events.setTitle(eventsDTO.getTitle());
        events.setEventId(eventsDTO.getEventId());
        eventRepository.save(events);
        return new ResponseEntity<EventsDTO>().success(null);
    }

    @PutMapping("/update/event")
    public ResponseEntity<EventsDTO> updateEvent(@RequestBody EventsDTO eventsDTO) {
        if (eventsDTO.getEventId() == null) {
            return new ResponseEntity<EventsDTO>().fail("please specify which Event to update.");
        }
       return addEvent(eventsDTO);
    }

    @DeleteMapping("/delete/event")
    public ResponseEntity<EventsDTO> deleteEvent(@RequestParam Integer eventId) {
        eventRepository.deleteById(eventId);
        return new ResponseEntity<EventsDTO>().success(null);
    }
}
