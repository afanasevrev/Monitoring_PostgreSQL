package com.example.Monitoring;

import java.util.List;
public interface EventsService {
    String createEvent(EventsEntity entity);
    List<EventsEntity> readEvents();
    EventsEntity readEvent(Long id);
    String deleteEvent(Long id);
    String updateEvent(EventsEntity entity, Long id);
}
