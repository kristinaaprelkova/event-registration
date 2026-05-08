package com.github.kristinaaprelkova.event_registration.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;



@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotNull
    @Future
    private LocalDateTime eventTime;

    @NotNull
    @Min(1)
    private Integer maxParticipants;

    public Event(){

    }

    public Event(String title, LocalDateTime eventTime, Integer maxParticipants){
        this.title = title;
        this.eventTime = eventTime;
        this.maxParticipants = maxParticipants;
    }

    public Long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public LocalDateTime getEventTime(){
        return eventTime;
    }

    public Integer getMaxParticipants(){
        return maxParticipants;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEventTime(LocalDateTime eventTime) {
        this.eventTime = eventTime;
    }

    public void setMaxParticipants(Integer maxParticipants) {
        this.maxParticipants = maxParticipants;
    }
}
