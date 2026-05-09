package com.github.kristinaaprelkova.event_registration.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "participants")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String personalCode;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public Participant() {
    }

    public Participant(String firstName, String lastName, String personalCode, Event event) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalCode = personalCode;
        this.event = event;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public Event getEvent() {
        return event;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}