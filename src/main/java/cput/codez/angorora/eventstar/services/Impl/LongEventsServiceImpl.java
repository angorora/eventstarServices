/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cput.codez.angorora.eventstar.services.Impl;

import cput.codez.angorora.eventstar.model.Event;
import cput.codez.angorora.eventstar.repository.EventRepository;
import cput.codez.angorora.eventstar.services.LongEventsService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marc
 */
@Service
public class LongEventsServiceImpl implements LongEventsService {
    @Autowired
    private EventRepository evRepo;
    static final long ms_in_day = 24*3600*1000;
   
    @Override
    public List<Event> getLongEvents() {
    List<Event> allEvents = new ArrayList<>();
    List<Event>longevents= new ArrayList<>();
    Calendar cal=new GregorianCalendar();
    allEvents =evRepo.findAll();
    for(Event allEv:allEvents){
    if((allEv.getEndDate().getTimeInMillis()-allEv.getStartDate().getTimeInMillis())>=ms_in_day)
        longevents.add(allEv);
    }
    return longevents;
    }
}
