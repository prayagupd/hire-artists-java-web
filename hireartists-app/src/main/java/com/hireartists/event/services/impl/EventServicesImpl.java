package com.hireartists.event.services.impl;

import com.hireartists.client.model.EventModel;
import com.hireartists.domain.Event;
import com.hireartists.domain.EventOrganiser;
import com.hireartists.event.repository.EventRepository;
import com.hireartists.event.services.EventServices;
import com.hireartists.eventOrganiser.repositories.EventOrganiserRepository;
import com.hireartists.eventOrganiser.service.EventOrganiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Binod on 7/15/2015.
 */

@Service
public class EventServicesImpl implements EventServices{

    @Autowired
    EventRepository eventRepository;

    @Autowired
    EventOrganiserService eventOrganiserService;

    @Transactional
    @Override
    public Event save(EventModel eventModel, String username) {
        Event event = new Event();
        event.setName(eventModel.name);
        EventOrganiser eventOrganiser = eventOrganiserService.findByUsername(username);
        event.setEventOrganiser(eventOrganiser);
        return eventRepository.save(event);
    }

    @Override
    public Event findOne(Long id) {
        return eventRepository.findOne(id);
    }

    @Override
    public List<Event> getEventsByEventOrganiserUsername(String username) {
        return eventRepository.getEventsByEventOrganiserUsername(username);
    }

    @Override
    public List<Event> findAll() {
        return null;
    }
}
