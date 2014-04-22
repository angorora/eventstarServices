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
    private String roomName;
    private long capacity;

   private Room() {
    }

    private Room(Builder build) {
        this.roomName = build.roomName;
        this.capacity = build.capacity;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public static class Builder {

        private String roomName;
        private long capacity;

        public Builder(String room) {
            this.roomName = room;
        }

        public Builder capacity(long capacity) {
            this.capacity = capacity;
            return this;
        }

        public Room build() {
            return new Room(this);
        }

        public Builder copier(Room room) {
            this.roomName = room.roomName;
            this.capacity = room.capacity;
            return this;
        }
    }

    public String getId() {
        return roomName;
    }

    public void setId(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomName != null ? roomName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the roomName fields are not set
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.roomName == null && other.roomName != null) || (this.roomName != null && !this.roomName.equals(other.roomName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cput.codez.angorora.eventstar.model.Room[ roomName=" + roomName + " ]";
    }

}
