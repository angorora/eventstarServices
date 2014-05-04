/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.eventstar.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author marc
 */
@Embeddable
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;

    private long capacity;
    private String roomName;

    private Room() {
    }

    private Room(Builder build) {
        this.capacity = build.capacity;
        this.roomName = build.roomName;
    }

    public String getRoomName() {
        return roomName;
    }

    public long getCapacity() {
        return capacity;
    }

    public static class Builder {

        private long capacity;
        private String roomName;

        public Builder(long capacity) {
            this.capacity = capacity;
        }

        public Builder roomName(String roomName) {
            this.roomName = roomName;
            return this;
        }

        public Room build() {
            return new Room(this);
        }

        public Builder copier(Room room) {

            this.capacity = room.capacity;
            this.roomName = room.roomName;
            return this;
        }
    }

}
