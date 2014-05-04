/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cput.codez.angorora.eventstar.services;

import cput.codez.angorora.eventstar.model.Event;
import java.util.List;

/**
 *
 * @author marc
 */
public interface ReassignStaffService {
    public Event getAssignedStaff(List<String> staff,String eventName);
}
