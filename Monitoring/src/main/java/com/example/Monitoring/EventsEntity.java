package com.example.Monitoring;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "events_entity")
public class EventsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "current_date")
    private String current_date;
    @Column(name = "user")
    private String user;
    @Column(name = "action")
    private String action;
    public EventsEntity() {}
    public EventsEntity(String current_date, String user, String action) {
        this.current_date = current_date;
        this.user = user;
        this.action = action;
    }
}
