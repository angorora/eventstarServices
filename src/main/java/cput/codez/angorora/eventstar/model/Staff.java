/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.eventstar.model;

import java.io.Serializable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author marc
 */
@Entity
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long staffid;
    private long eventId;
    private String staffName;
    private String staffSurname;
    private String role;
    @Embedded
    private Contact contact;

    public Staff() {
    }

    public Staff(Builder build) {
        this.staffName = build.staffName;
        this.staffSurname = build.staffSurname;
        this.staffid = build.staffid;
        this.role = build.role;
        this.contact = build.contact;
        this.eventId = build.eventId;
    }

    public Long getStaffid() {
        return staffid;
    }

    public void setStaffid(Long staffid) {
        this.staffid = staffid;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffSurname() {
        return staffSurname;
    }

    public void setStaffSurname(String staffSurname) {
        this.staffSurname = staffSurname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public static class Builder {

        private Long staffid;
        private long eventId;
        private String staffName;
        private String staffSurname;
        private String role;
        @Embedded
        private Contact contact;

        public Builder(String name) {
            this.staffName = name;
        }

        public Builder eventId(long eventId) {
            this.eventId = eventId;
            return this;
        }

        public Builder surname(String surname) {
            this.staffSurname = surname;
            return this;
        }

        public Builder contact(Contact cont) {
            this.contact = cont;
            return this;
        }

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public Staff build() {
            return new Staff(this);
        }

        public Builder copier(Staff staff) {
            this.staffName = staff.staffName;
            this.staffSurname = staff.staffSurname;
            this.staffid = staff.staffid;
            this.role = staff.role;
            this.contact = staff.contact;
            this.eventId = staff.eventId;
            return this;
        }
    }

    public Long getId() {
        return staffid;
    }

    public void setId(Long staffid) {
        this.staffid = staffid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffid != null ? staffid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the staffid fields are not set
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.staffid == null && other.staffid != null) || (this.staffid != null && !this.staffid.equals(other.staffid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cput.codez.angorora.eventstar.model.Staff[ staffid=" + staffid + " ]";
    }

}
