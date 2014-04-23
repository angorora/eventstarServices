/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.eventstar.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author marc
 */
@Entity
public class Attendee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attendeeId;
    private long eventId;
    private String firstName;
    private String lastName;
    private String gender;
    @Embedded
    private Contact contact;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "attendeeId" )
    private Payment pay;
    private int age;
    private String companyName;
    private String diet;

    public Long getId() {
        return attendeeId;
    }

    public void setId(Long attendeeId) {
        this.attendeeId = attendeeId;
    }

    private Attendee() {
    }

    private Attendee(Builder build) {
        this.contact = build.contact;
        this.firstName = build.firstName;
        this.lastName = build.lastName;
        this.gender = build.gender;
        this.attendeeId = build.attendeeId;
        this.pay = build.pay;
        this.diet = build.diet;
        this.age = build.age;
        this.eventId=build.eventId;
    }

    public Long getAttendeeId() {
        return attendeeId;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public void setAttendeeId(Long attendeeId) {
        this.attendeeId = attendeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Payment getPay() {
        return pay;
    }

    public void setPay(Payment pay) {
        this.pay = pay;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public static class Builder {

        private Long attendeeId;
        private long eventId;
        private String firstName;
        private String lastName;
        private String gender;
        @Embedded
        private Contact contact;
        @OneToMany
        @JoinColumn(name = "attendeeId")
        private Payment pay;
        private int age;
        private String companyName;
        private String diet;

        public Builder(Contact cont) {
            this.contact = cont;
        }

        public Builder attendeeId(long attId) {
            this.attendeeId = attId;
            return this;
        }

        public Builder firstName(String fname) {
            this.firstName = fname;
            return this;
        }

        public Builder lastName(String lname) {
            this.lastName = lname;
            return this;
        }
        public Builder eventId(long evId){
            this.eventId=evId;
            return this;
        }
        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder diet(String diet) {
            this.diet = diet;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder pay(Payment pay) {
            this.pay = pay;
            return this;
        }

        public Builder company(String cname) {
            this.companyName = cname;
            return this;
        }

        public Attendee build() {
            return new Attendee(this);
        }

        public Builder copier(Attendee att) {
            this.age = att.age;
            this.attendeeId = att.attendeeId;
            this.companyName = att.companyName;
            this.contact = att.contact;
            this.diet = att.diet;
            this.firstName = att.firstName;
            this.gender = att.gender;
            this.pay = att.pay;
            this.eventId=att.eventId;
            return this;
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attendeeId != null ? attendeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the attendeeId fields are not set
        if (!(object instanceof Attendee)) {
            return false;
        }
        Attendee other = (Attendee) object;
        if ((this.attendeeId == null && other.attendeeId != null) || (this.attendeeId != null && !this.attendeeId.equals(other.attendeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cput.codez.angorora.eventstar.model.Attendee[ attendeeId=" + attendeeId + " ]";
    }
}
