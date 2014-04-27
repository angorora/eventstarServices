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
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long capacity;
    private String roomName;

    private Room() {
    }

    private Room(Builder build) {
        this.id = build.id;
        this.capacity = build.capacity;
        this.roomName=build.roomName;
    }

    public Long getId() {
        return id;
    }

    public String getRoomName() {
        return roomName;
    }

    public long getRoomId() {
        return id;
    }

    public long getCapacity() {
        return capacity;
    }

    

    public static class Builder {

        private Long id;
        private long capacity;
        private String roomName;

        public Builder(long capacity) {
            this.capacity = capacity;
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

         public Builder roomName(String roomName) {
            this.roomName = roomName;
            return this;
        }

        public Room build() {
            return new Room(this);
        }

        public Builder copier(Room room) {
            this.id = room.id;
            this.capacity = room.capacity;
            this.roomName=room.roomName;
            return this;
        }
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
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cput.codez.angorora.eventstar.model.Room[ id=" + id + " ]";
    }

}
