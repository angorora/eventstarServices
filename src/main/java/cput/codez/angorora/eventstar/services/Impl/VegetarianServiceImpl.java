/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cput.codez.angorora.eventstar.services.Impl;

import cput.codez.angorora.eventstar.model.Attendee;
import cput.codez.angorora.eventstar.model.Event;
import cput.codez.angorora.eventstar.repository.EventRepository;
import cput.codez.angorora.eventstar.services.VegetarianService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marc
 */
@Service
public class VegetarianServiceImpl implements VegetarianService {
@Autowired
private EventRepository evRepo;
    @Override
    public long getVegetarians(String eventName) {
       List<Event> allEvents = new ArrayList<>();
       List<Attendee> allAttendees = new ArrayList<>();
       Event event;
       List<Attendee> vegetarians=new ArrayList<>();
       allEvents=evRepo.findAll();
       for(Event ev:allEvents){
           if(ev.getEventName().equalsIgnoreCase(eventName)){
              allAttendees.addAll(ev.getAtt());
              for(Attendee att:allAttendees){
                  if(att.getDiet().equalsIgnoreCase("Vegaterian"))
                      vegetarians.add(att);
              }
           }
               
       }
     return vegetarians.size();
    }
    
}
