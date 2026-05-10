package com.github.kristinaaprelkova.event_registration.controller;

import com.github.kristinaaprelkova.event_registration.entity.Event;
import com.github.kristinaaprelkova.event_registration.repository.EventRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "http://localhost:5173")
public class EventController {

    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // GET /api/events
    @GetMapping
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // POST /api/events
    @PostMapping
    public Event createEvent(
            @RequestHeader(value = "X-ADMIN", required = false) String isAdmin,
            @RequestBody Event event
    ) {
        if (!"true".equals(isAdmin)) {
            throw new RuntimeException("Only admin can create events");
        }

        return eventRepository.save(event);
    }
}
