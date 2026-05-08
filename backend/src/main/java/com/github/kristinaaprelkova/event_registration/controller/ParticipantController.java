package com.github.kristinaaprelkova.event_registration.controller;

import com.github.kristinaaprelkova.event_registration.entity.Event;
import com.github.kristinaaprelkova.event_registration.entity.Participant;
import com.github.kristinaaprelkova.event_registration.repository.EventRepository;
import com.github.kristinaaprelkova.event_registration.repository.ParticipantRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class ParticipantController {

    private final EventRepository eventRepository;
    private final ParticipantRepository participantRepository;

    public ParticipantController(EventRepository eventRepository,
                                 ParticipantRepository participantRepository) {
        this.eventRepository = eventRepository;
        this.participantRepository = participantRepository;
    }

    @PostMapping("/{eventId}/register")
    public Participant registerParticipant(
            @PathVariable Long eventId,
            @RequestBody Participant participant
    ) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        participant.setEvent(event);

        return participantRepository.save(participant);
    }
}
