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
    @Column(name = "mon_usename")
    private String mon_usename;
    @Column(name = "mon_query")
    private String mon_query;
    @Column(name = "mon_date")
    private String mon_date;
    @Column(name = "mon_address")
    private String mon_address;
    @Column(name = "mon_application")
    private String mon_application;
    public EventsEntity() {}
    public EventsEntity(String mon_usename, String mon_query, String mon_date, String mon_address, String mon_application) {
        this.mon_usename = mon_usename;
        this.mon_query = mon_query;
        this.mon_date = mon_date;
        this.mon_address = mon_address;
        this.mon_application = mon_application;
    }
}
