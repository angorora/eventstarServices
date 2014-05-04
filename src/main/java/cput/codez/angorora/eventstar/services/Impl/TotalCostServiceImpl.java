/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cput.codez.angorora.eventstar.services.Impl;

import cput.codez.angorora.eventstar.model.Event;
import cput.codez.angorora.eventstar.repository.EventRepository;
import cput.codez.angorora.eventstar.services.TotalCostService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marc
 */
@Service
public class TotalCostServiceImpl implements TotalCostService{
@Autowired
private EventRepository eventRepo;
    @Override
    public double getTotalCost(String eventName) {
        double totalCost=0;
        List<Event> eventList = new ArrayList<>();
        eventList=eventRepo.findAll();
        for(Event ev: eventList){
            if(ev.getEventName().equalsIgnoreCase(eventName)){
                totalCost=ev.getBudget().getAudioVisualCost()
                        +ev.getBudget().getDecorCost()
                        +ev.getBudget().getFoodCost()
                        +ev.getBudget().getMarketingCost()
                        +ev.getBudget().getPhotographyCost()
                        +ev.getBudget().getSecurityCost()                     
                        +ev.getBudget().getTransportCost() 
                        +ev.getBudget().getVenueCost()
                        +ev.getBudget().getSpeakerCosts()
                        +ev.getBudget().getSecurityCost();
            }
        }
        return totalCost;
    }
    
}
