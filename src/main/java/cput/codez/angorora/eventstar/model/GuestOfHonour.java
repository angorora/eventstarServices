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
public class GuestOfHonour implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String guestName;
    private String guestSurname;
    private String guestInfo;
    @Embedded
    private Contact contact;
    private GuestOfHonour() {

    }

    private GuestOfHonour(Builder build) {
        this.contact = build.contact;
        this.guestInfo = build.guestInfo;
        this.guestName = build.guestName;
        this.guestSurname = build.guestSurname;
        this.id = build.id;
    }
  public String getGuestName() {
        return guestName;
    }

    public String getGuestSurname() {
        return guestSurname;
    }

    public String getGuestInfo() {
        return guestInfo;
    }

    public Contact getContact() {
        return contact;
    }

    public static class Builder {

        private Long id;
        private String guestName;
        private String guestSurname;
        private String guestInfo;
        @Embedded
        private Contact contact;
        public Builder(String guestname) {
            this.guestName = guestname;
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder surname(String surname) {
            this.guestSurname = surname;
            return this;
        }

        public Builder guestInfo(String info) {
            this.guestInfo = info;
            return this;
        }

        public Builder contact(Contact cont) {
            this.contact = cont;
            return this;
        }
        public GuestOfHonour build() {
            return new GuestOfHonour(this);
        }
        
        public Builder copier(GuestOfHonour guest) {
            this.id = guest.id;
            this.guestName = guest.guestName;
            this.guestSurname = guest.guestSurname;
            this.contact = guest.contact;
            this.guestInfo = guest.guestInfo;
            return this;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof GuestOfHonour)) {
            return false;
        }
        GuestOfHonour other = (GuestOfHonour) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cput.codez.angorora.eventstar.model.GuestOfHonour[ id=" + id + " ]";
    }

}
