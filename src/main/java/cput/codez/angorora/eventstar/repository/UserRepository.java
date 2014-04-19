/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cput.codez.angorora.eventstar.repository;

import cput.codez.angorora.eventstar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author marc
 */
public interface UserRepository extends JpaRepository<User,Long>{
    
}
