package com.github.kristinaaprelkova.event_registration.repository;

import com.github.kristinaaprelkova.event_registration.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    long countByEventId(Long eventId);

}
