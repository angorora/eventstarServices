/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.eventstar.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
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
    private String venueName;
    @Embedded
    private Address address;
    @OneToMany
    @JoinColumn(name = "venueId")
    private List<Room> roomid;
    private long capacity;

    public Venue() {
    }

    public Venue(Builder build) {
        this.venueId = build.venueId;
        this.address = build.address;
        this.capacity = build.capacity;
        this.venueName = build.venueName;
        this.roomid = build.roomid;
    }

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Room> getRoomid() {
        return roomid;
    }

    public void setRoomid(List<Room> roomid) {
        this.roomid = roomid;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public static class Builder {

        private Long venueId;
        private String venueName;
        @Embedded
        private Address address;
        @OneToMany
        @JoinColumn(name = "venueId")
        private List<Room> roomid;
        private long capacity;

        public Builder(String venuename) {
            this.venueName = venuename;
        }

        public Builder venueid(long venueid) {
            this.venueId = venueid;
            return this;
        }

        public Builder address(Address addr) {
            this.address = addr;
            return this;
        }

        public Builder room(List<Room> room) {
            this.roomid = room;
            return this;
        }

        public Builder capacity(long capacity) {
            this.capacity = capacity;
            return this;
        }

        public Venue build() {
            return new Venue(this);
        }

        public Builder copier(Venue venue) {
            this.venueId = venue.venueId;
            this.address = venue.address;
            this.capacity = venue.capacity;
            this.venueName = venue.venueName;
            this.roomid = venue.roomid;
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
