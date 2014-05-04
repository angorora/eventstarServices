/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cput.codez.angorora.eventstar.services.Impl;

import cput.codez.angorora.eventstar.model.Event;
import cput.codez.angorora.eventstar.repository.EventRepository;
import cput.codez.angorora.eventstar.services.SameDayService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marc
 */
@Service
public class SameDayServiceImpl implements SameDayService{
@Autowired
private EventRepository evRepo;

    @Override
    public List<Event> getConcurrentEvents(Calendar dt) {
        List<Event>allEvents=new ArrayList<>();
        List<Event>samedayList=new ArrayList<>();
        allEvents=evRepo.findAll();
        for(Event ev:allEvents){
            if(DateUtils.isSameDay(ev.getStartDate(), dt))
                samedayList.add(ev);
        }
        return samedayList;
    }
    
}
