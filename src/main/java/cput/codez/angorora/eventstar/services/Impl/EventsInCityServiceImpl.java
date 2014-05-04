/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cput.codez.angorora.eventstar.services.Impl;

import cput.codez.angorora.eventstar.model.Event;
import cput.codez.angorora.eventstar.model.Venue;
import cput.codez.angorora.eventstar.repository.EventRepository;
import cput.codez.angorora.eventstar.repository.VenueRepository;
import cput.codez.angorora.eventstar.services.EventsInCityService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marc
 */
@Service
public class EventsInCityServiceImpl implements EventsInCityService{
    @Autowired
    private EventRepository eventRepo;
    @Autowired 
    private VenueRepository venRepo;

    @Override
    public List<Event> getEventsInCity(String city) {
        List<Venue> venues = new ArrayList<>();
        List<Event> events=new ArrayList<>();
        venues=venRepo.findAll();
        for(Venue ven:venues){
            if(ven.getAddress().getCity().equalsIgnoreCase(city)){
                events.addAll(ven.getEvent());
            }
        }
        return events;
    }
    
}
