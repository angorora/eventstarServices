/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cput.codez.angorora.eventstar.services.Impl;

import cput.codez.angorora.eventstar.model.Attendee;
import cput.codez.angorora.eventstar.model.Event;
import cput.codez.angorora.eventstar.repository.EventRepository;
import cput.codez.angorora.eventstar.services.TotalFeesService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marc
 */
@Service
public class TotalFeesServiceImpl implements TotalFeesService{
@Autowired
private EventRepository evRepo;
    @Override
    public double getTotalFees(String eventName) {
       List<Event> allEvents= new ArrayList<>();
       double totFees=0;
       allEvents=evRepo.findAll();
       for(Event ev:allEvents){
           if(ev.getEventName().equalsIgnoreCase(eventName)){
               for(Attendee att:ev.getAtt()){
                   totFees=totFees+att.getPayment().getAmount();
               }
           }
           
       }
       return totFees;
    }
    
}
