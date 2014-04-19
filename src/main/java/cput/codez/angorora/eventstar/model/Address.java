/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cput.codez.angorora.eventstar.model;

import javax.persistence.Embeddable;

/**
 *
 * @author marc
 */
@Embeddable
public class Address {
  private String streetnum;
  private String surburb;
  private String city;
  private String country;
  private  String postalcode;
  
    
 }