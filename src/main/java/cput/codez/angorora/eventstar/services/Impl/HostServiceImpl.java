/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cput.codez.angorora.eventstar.services.Impl;

import cput.codez.angorora.eventstar.model.Event;
import cput.codez.angorora.eventstar.model.Host;
import cput.codez.angorora.eventstar.repository.HostRepository;
import cput.codez.angorora.eventstar.services.HostService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marc
 */
@Service
public class HostServiceImpl implements HostService{
@Autowired
private HostRepository hostRepo;

    @Override
    public List<Event> getEventsForHost(String hostName) {
        List<Event> theEvents = new ArrayList<>();
        List<Host> allHosts= new ArrayList<>();
        allHosts=hostRepo.findAll();
        for(Host host:allHosts)
        {
            if(host.getHostName().equalsIgnoreCase(hostName))
                theEvents.addAll(host.getEvent());
        }
           return theEvents;
    }
 
    
}
