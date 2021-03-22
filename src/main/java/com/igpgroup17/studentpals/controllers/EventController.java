package com.igpgroup17.studentpals.controllers;

import com.igpgroup17.studentpals.models.Event;
import com.igpgroup17.studentpals.models.Student;
import com.igpgroup17.studentpals.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/v1/events/{id}")
    public ResponseEntity<?> getEventById(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(eventService.readEvent(id));
    }

    @PostMapping("/v1/events")
    public ResponseEntity<?> createEvent(@RequestBody Event event) {
        return ResponseEntity.ok(eventService.createEvent(event));
    }

    @PutMapping("/v1/events")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        return ResponseEntity.ok(eventService.addStudent(student));
    }

    @PutMapping("/v1/events")
    public ResponseEntity<?> addInterestedStudent(@RequestBody Student student) {
        return ResponseEntity.ok(eventService.addInterestedStudent(student));
    }

    @PutMapping("/v1/events")
    public ResponseEntity<?> updateEvent(@RequestBody Event event) {
        return ResponseEntity.ok(eventService.updateEvent(event));
    }

    @DeleteMapping("/v1/events/{id}")
    public ResponseEntity<?> deleteEventById(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(eventService.deleteEvent(id));
    }
}
