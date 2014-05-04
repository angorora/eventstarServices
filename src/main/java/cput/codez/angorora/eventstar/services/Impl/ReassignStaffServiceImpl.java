/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cput.codez.angorora.eventstar.services.Impl;

import cput.codez.angorora.eventstar.model.Event;
import cput.codez.angorora.eventstar.model.Staff;
import cput.codez.angorora.eventstar.repository.EventRepository;
import cput.codez.angorora.eventstar.repository.StaffRepository;
import cput.codez.angorora.eventstar.services.ReassignStaffService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marc
 */
@Service
public class ReassignStaffServiceImpl implements ReassignStaffService{
@Autowired
private EventRepository evRepo;
@Autowired
private StaffRepository staffRepo;
    @Override
    public Event getAssignedStaff(List<String> staff, String eventName) {
        List<Event>allEvents= new ArrayList<>();
        List<Staff>allStaff= new ArrayList<>();
        List<Staff>assignedStaff=new ArrayList<>();
        Event newEvent=null;
        allEvents=evRepo.findAll();
        allStaff=staffRepo.findAll();
        for(Staff st:allStaff){
            if(staff.contains(st.getStaffSurname())){
                assignedStaff.add(st);
            }
        }
        for(Event ev:allEvents) {
            if(ev.getEventName().equalsIgnoreCase(eventName)){
                newEvent=new Event.Builder(eventName).copier(ev).staff(assignedStaff).build();
                evRepo.save(newEvent);
            }
        }   
        return newEvent;
    }
    
}
