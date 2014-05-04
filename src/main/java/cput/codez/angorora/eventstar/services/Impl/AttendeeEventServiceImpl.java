/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.eventstar.services.Impl;

import cput.codez.angorora.eventstar.model.Attendee;
import cput.codez.angorora.eventstar.model.Event;
import cput.codez.angorora.eventstar.repository.AttendeeRepository;
import cput.codez.angorora.eventstar.repository.EventRepository;
import cput.codez.angorora.eventstar.services.AttendeeEventService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marc
 */
@Service
public class AttendeeEventServiceImpl implements AttendeeEventService {

    @Autowired
    private AttendeeRepository attRepo;
    @Autowired
    private EventRepository evRepo;

    @Override
    public List<Event> getEvents(String id) {
        List<Attendee> allAttendees = new ArrayList<>();
        Attendee rightAtt = null;
        List<Event> allEvents = new ArrayList<>();
        List<Event> eventsAttended = new ArrayList<>();
        allAttendees = attRepo.findAll();
        allEvents = evRepo.findAll();
        for (Attendee att : allAttendees) {
            if (att.getID().equalsIgnoreCase(id)) {
                rightAtt = att;
            }
        }
        for (Event ev : allEvents) {
            if (ev.getAtt().contains(rightAtt)) {
                eventsAttended.add(ev);
            }
        }
        return eventsAttended;
    }
}
