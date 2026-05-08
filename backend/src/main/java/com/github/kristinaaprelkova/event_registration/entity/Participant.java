package com.github.kristinaaprelkova.event_registration.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "participants")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public Participant() {
    }

    public Participant(String name, String email, Event event) {
        this.name = name;
        this.email = email;
        this.event = event;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Event getEvent() {
        return event;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}