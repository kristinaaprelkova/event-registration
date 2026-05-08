package com.github.kristinaaprelkova.event_registration.repository;

import com.github.kristinaaprelkova.event_registration.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}

