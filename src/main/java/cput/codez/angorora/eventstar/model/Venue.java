/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.eventstar.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author marc
 */
@Entity
public class Venue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long venueId;
    @Column(unique = true)
    private String venueName;
    @Embedded
    private Address address;
    @Embedded
    private Room room;
    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name = "venueId")
    private List<Event> event;

    public Venue() {
    }

    public Venue(Builder build) {
        this.venueId = build.venueId;
        this.address = build.address;
        this.venueName = build.venueName;
        this.room = build.room;
        this.event = build.event;
    }

    public Long getVenueId() {
        return venueId;
    }

    public List<Event> getEvent() {
        return event;
    }

    public String getVenueName() {
        return venueName;
    }

    public Address getAddress() {
        return address;
    }

    public Room getRoom() {
        return room;
    }

    public static class Builder {

        private Long venueId;
        private String venueName;
        private Address address;
        private Room room;
        private List<Event> event;

        public Builder(String venuename) {
            this.venueName = venuename;
        }

        public Builder venueid(long venueid) {
            this.venueId = venueid;
            return this;
        }

        public Builder event(List<Event> event) {
            this.event = event;
            return this;
        }

        public Builder address(Address addr) {
            this.address = addr;
            return this;
        }

        public Builder room(Room room) {
            this.room = room;
            return this;
        }

        public Venue build() {
            return new Venue(this);
        }

        public Builder copier(Venue venue) {
            this.venueId = venue.venueId;
            this.address = venue.address;
            this.venueName = venue.venueName;
            this.room = venue.room;
            this.event=venue.event;
            return this;
        }
    }

    public Long getId() {
        return venueId;
    }

    public void setId(Long venueId) {
        this.venueId = venueId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (venueId != null ? venueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the venueId fields are not set
        if (!(object instanceof Venue)) {
            return false;
        }
        Venue other = (Venue) object;
        if ((this.venueId == null && other.venueId != null) || (this.venueId != null && !this.venueId.equals(other.venueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cput.codez.angorora.eventstar.model.Venue[ venueId=" + venueId + " ]";
    }

}
