package com.example.Monitoring;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
public class EventsServiceImpl implements EventsService {
    @Autowired
    private EventsRepository eventsRepository;
    @Override
    public String createEvent(EventsEntity entity) {
        eventsRepository.save(entity);
        return "Событие успешно добавлено в БД";
    }
    @Override
    public List<EventsEntity> readEvents() {
        return eventsRepository.findAll();
    }
    @Override
    public EventsEntity readEvent(Long id) {
        return eventsRepository.findById(id).get();
    }
    @Override
    public String deleteEvent(Long id) {
        eventsRepository.deleteById(id);
        return "Событие с ID = " + id + " успешно удалено из БД";
    }
    @Override
    public String updateEvent(EventsEntity entity, Long id) {
        EventsEntity eventsEntity = eventsRepository.findById(id).get();
        eventsEntity.setToday_date(entity.getToday_date());
        eventsEntity.setAction(entity.getAction());
        eventsEntity.setClient(entity.getClient());
        eventsRepository.save(eventsEntity);
        return "Событие с ID = " + id + " успешно обновлено в БД";
    }
}