/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cput.codez.angorora.eventstar.services.Impl;

import cput.codez.angorora.eventstar.model.Event;
import cput.codez.angorora.eventstar.model.Statistics;
import cput.codez.angorora.eventstar.repository.EventRepository;
import cput.codez.angorora.eventstar.services.StatisticsService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marc
 */
@Service
public class StatisticsServiceImpl implements StatisticsService{
@Autowired
private EventRepository evRepo;
    @Override
    public Statistics getStatistics(String eventName) {
      Statistics stats=null;
      List<Event> allEvents =new ArrayList<>();
      allEvents=evRepo.findAll();
      for(Event ev:allEvents){
          if(ev.getEventName().equalsIgnoreCase(eventName))
              stats=ev.getStats();
      }
      return stats;
    }
    
}
