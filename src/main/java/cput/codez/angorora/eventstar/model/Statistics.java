/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.eventstar.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author marc
 */
@Entity
public class Statistics implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long numOfAttendees;
    private long maleAttendees;
    private long femaleAttendees;
    private int rating;

    private Statistics() {
    }

    private Statistics(Builder build) {
       this.femaleAttendees = build.femaleAttendees;
        this.id = build.id;
        this.maleAttendees = build.maleAttendees;
        this.numOfAttendees = build.numOfAttendees;
        this.rating = build.rating;
    }

    public long getNumOfAttendees() {
        return numOfAttendees;
    }

    public long getMaleAttendees() {
        return maleAttendees;
    }

 
    public long getFemaleAttendees() {
        return femaleAttendees;
    }

  

    public int getRating() {
        return rating;
    }

    public static class Builder {

        private Long id;
        private long numOfAttendees;
        private long maleAttendees;
        private long femaleAttendees;
        private int rating;
        public Builder (int rating) {
            this.rating = rating;
        }
        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder attendees(long attendees) {
            this.numOfAttendees = attendees;
            return this;
        }

        public Builder males(long males) {
            this.maleAttendees = males;
            return this;
        }

        public Builder females(long females) {
            this.femaleAttendees = females;
            return this;
        }

        

        public Statistics build() {
            return new Statistics(this);
        }

        public Builder copier(Statistics stats) {
            this.femaleAttendees = stats.femaleAttendees;
            this.id = stats.id;
            this.maleAttendees = stats.maleAttendees;
            this.numOfAttendees = stats.numOfAttendees;
            this.rating = stats.rating;
            return this;
        }
    }

    public Long getId() {
        return id;
    }

       @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statistics)) {
            return false;
        }
        Statistics other = (Statistics) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cput.codez.angorora.eventstar.model.Statistics[ id=" + id + " ]";
    }

}
