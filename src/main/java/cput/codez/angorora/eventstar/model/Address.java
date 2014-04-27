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
    private String postalcode;

    private Address() {
    }

    private Address(Builder build) {
        this.city=build.city;
        this.country=build.country;
        this.streetnum=build.streetnum;
        this.surburb=build.surburb;
        this.postalcode=build.postalcode;
    }

    public String getStreetnum() {
        return streetnum;
    }

    public void setStreetnum(String streetnum) {
        this.streetnum = streetnum;
    }

    public String getSurburb() {
        return surburb;
    }

    public void setSurburb(String surburb) {
        this.surburb = surburb;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public static class Builder {

        private String streetnum;
        private String surburb;
        private String city;
        private String country;
        private String postalcode;
        
        public Builder(String city){
            this.city=city;
        }
        public Builder streetnum(String strnum){
            this.streetnum=strnum;
            return this;
        }
        public Builder surbub(String surbub){
            this.surburb=surbub;
            return this;
        }
        public Builder country(String country){
            this.country=country;
            return this;
        }
        public Builder postal(String poscode){
            this.postalcode=poscode;
            return this;           
        }
        public Address build(){
            return new Address(this);
        }
        public Builder copier(Address addr){
            this.city=addr.city;
            this.country=addr.country;
            this.postalcode=addr.postalcode;
            this.streetnum=addr.streetnum;
            this.surburb=addr.surburb;
            return this;
        }
    }

}
