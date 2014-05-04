/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cput.codez.angorora.eventstar.services.Impl;

import cput.codez.angorora.eventstar.model.Host;
import cput.codez.angorora.eventstar.repository.HostRepository;
import cput.codez.angorora.eventstar.services.FreqHostService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marc
 */
@Service
public class FreqHostServiceImpl implements FreqHostService{
@Autowired
private HostRepository hostRepo;
    @Override
    public Host getFreqHost() {
        List<Host>allHosts=new ArrayList<>();
        Host maxHost=null;
        int max=0;
        allHosts=hostRepo.findAll();
        for(Host host:allHosts){
            if(host.getEvent().size()>max)
                maxHost=host;
        }
           return maxHost;
    }
    
}
