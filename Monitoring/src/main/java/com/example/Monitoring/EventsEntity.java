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
    @Column(name = "today_date")
    private String today_date;
    @Column(name = "client")
    private String client;
    @Column(name = "action")
    private String action;
    public EventsEntity() {}
    public EventsEntity(String today_date, String client, String action) {
        this.today_date = today_date;
        this.client = client;
        this.action = action;
    }
}
