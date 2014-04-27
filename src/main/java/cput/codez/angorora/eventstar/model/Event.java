/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.eventstar.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eventId;
    @Column(unique = true)
    private String eventName;
    private String eventType;
    private Calendar startDate;
    private Calendar endDate;
    private String refundable;
    private double refundRate;
    private double price;
    @OneToMany
    @JoinColumn(name = "eventId")
    List<Staff> staff;
    @OneToMany @JoinColumn(name = "eventId")
    List<Attendee> att;
    @OneToMany
    @JoinColumn(name = "eventId")
    List<Supplier> supplier;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "eventId")
    private List<GuestOfHonour> guestOfHonour;
    @OneToOne
    @JoinColumn(name = "eventId")
    private Statistics stats;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "eventId")
    private Host host;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "eventId")
    private Budget budget;
    @Embedded
    private Reminder reminder;
    @Embedded
    private Invitation invitation;

    private Event() {
    }

    private Event(Builder build) {
        this.att = build.att;
        this.endDate = build.endDate;
        this.startDate = build.startDate;
        this.eventName = build.eventName;
        this.eventType = build.eventType;
        this.refundRate = build.refundRate;
        this.refundable = build.refundable;
        this.supplier = build.supplier;
        this.staff = build.staff;
        this.eventId = build.eventId;
        this.guestOfHonour = build.guestOfHonour;
        this.stats = build.stats;
        this.host = build.host;
        this.reminder = build.reminder;
        this.invitation = build.invitation;
        this.price = build.price;
        this.budget = build.budget;
    }

    public Budget getBudget() {
        return budget;
    }

    public Invitation getInvitation() {
        return invitation;
    }

    public Statistics getStats() {
        return stats;
    }

    public List<GuestOfHonour> getGuestOfHonour() {
        return guestOfHonour;
    }

    public Long getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public double getPrice() {
        return price;
    }

    public Host getHost() {
        return host;
    }

    public Reminder getReminder() {
        return reminder;
    }

    public String getEventType() {
        return eventType;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public String getRefundable() {
        return refundable;
    }

    public double getRefundRate() {
        return refundRate;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public List<Attendee> getAtt() {
        return att;
    }

    public List<Supplier> getSupplier() {
        return supplier;
    }

    public static class Builder {

        private Long eventId;
        private String eventName;
        private String eventType;
        private Calendar startDate;
        private Calendar endDate;
        private String refundable;
        private double refundRate;
        List<Staff> staff;
        List<Attendee> att;
        List<Supplier> supplier;
        private List<GuestOfHonour> guestOfHonour;
        private Statistics stats;
        private Reminder reminder;
        private Host host;
        private Invitation invitation;
        private Budget budget;
        private double price;

        public Builder(String eventName) {
            this.eventName = eventName;
        }

        public Builder budget(Budget budget) {
            this.budget = budget;
            return this;
        }

        public Builder eventId(long eventId) {
            this.eventId = eventId;
            return this;
        }

        public Builder eventType(String eventType) {
            this.eventType = eventType;
            return this;
        }

        public Builder host(Host host) {
            this.host = host;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder reminder(Reminder remind) {
            this.reminder = remind;
            return this;
        }

        public Builder invitation(Invitation invitation) {
            this.invitation = invitation;
            return this;
        }

        public Builder startDate(Calendar start) {
            this.startDate = start;
            return this;
        }

        public Builder endDate(Calendar end) {
            this.endDate = end;
            return this;
        }

        public Builder refundable(String refund) {
            this.refundable = refund;
            return this;
        }

        public Builder refundrate(double refundrate) {
            this.refundRate = refundrate;
            return this;
        }

        public Builder staff(List<Staff> staff) {
            this.staff = staff;
            return this;
        }

        public Builder attendee(List<Attendee> att) {
            this.att = att;
            return this;
        }

        public Builder supplier(List<Supplier> sup) {
            this.supplier = sup;
            return this;
        }

        public Builder guestOfHonour(List<GuestOfHonour> guest) {
            this.guestOfHonour = guest;
            return this;
        }

        public Builder stats(Statistics stats) {
            this.stats = stats;
            return this;
        }

        public Event build() {
            return new Event(this);
        }

        public Builder copier(Event ev) {
            this.att = ev.att;
            this.endDate = ev.endDate;
            this.startDate = ev.startDate;
            this.eventName = ev.eventName;
            this.eventType = ev.eventType;
            this.refundRate = ev.refundRate;
            this.refundable = ev.refundable;
            this.supplier = ev.supplier;
            this.staff = ev.staff;
            this.eventId = ev.eventId;
            this.guestOfHonour = ev.guestOfHonour;
            this.stats = ev.stats;
            this.host = ev.host;
            this.invitation = ev.invitation;
            this.reminder = ev.reminder;
            this.budget=ev.budget;
            return this;

        }
    }

    public Long getId() {
        return eventId;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventId != null ? eventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the eventId fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventId == null && other.eventId != null) || (this.eventId != null && !this.eventId.equals(other.eventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cput.codez.angorora.eventstar.model.Event[ eventId=" + eventId + " ]";
    }

}
