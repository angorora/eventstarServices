/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cput.codez.angorora.eventstar.services.Impl;

import cput.codez.angorora.eventstar.model.Event;
import cput.codez.angorora.eventstar.model.Refund;
import cput.codez.angorora.eventstar.repository.EventRepository;
import cput.codez.angorora.eventstar.services.RefundsService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marc
 */
@Service
public class RefundServiceImpl implements RefundsService{
     @Autowired
     private EventRepository evRepo;
    @Override
    public List<Refund> getRefund(String eventName) {
        List<Event> allEvents = new ArrayList();
        List<Refund> refunds=new ArrayList();
        allEvents=evRepo.findAll();
        for(Event ev:allEvents){
            if(ev.getEventName().equalsIgnoreCase(eventName)){
                refunds.addAll(ev.getRefund());
            }
        }
        return refunds;
    }
    
}
