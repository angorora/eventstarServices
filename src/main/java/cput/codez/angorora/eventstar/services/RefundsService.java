/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cput.codez.angorora.eventstar.services;

import cput.codez.angorora.eventstar.model.Refund;
import java.util.List;

/**
 *
 * @author marc
 */
public interface RefundsService {
    public List<Refund> getRefund(String eventName);
}
