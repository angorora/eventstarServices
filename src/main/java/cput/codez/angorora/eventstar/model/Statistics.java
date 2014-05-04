/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.eventstar.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author marc
 */
@Embeddable
public class Statistics implements Serializable {

    private static final long serialVersionUID = 1L;

    private long numOfAttendees;
    private long maleAttendees;
    private long femaleAttendees;
    private int rating;

    private Statistics() {
    }

    private Statistics(Builder build) {
        this.femaleAttendees = build.femaleAttendees;
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

        private long numOfAttendees;
        private long maleAttendees;
        private long femaleAttendees;
        private int rating;

        public Builder(int rating) {
            this.rating = rating;
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
            this.maleAttendees = stats.maleAttendees;
            this.numOfAttendees = stats.numOfAttendees;
            this.rating = stats.rating;
            return this;
        }
    }

}
