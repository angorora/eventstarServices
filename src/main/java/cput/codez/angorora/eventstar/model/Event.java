/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.eventstar.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
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
    private String eventName;
    private String eventType;
    private Calendar startDate;
    private Calendar endDate;
    private long hostId;
    private String refundable;
    private double refundRate;
    @OneToMany
    @JoinColumn(name = "eventId")
    List<Staff> staff;
    @OneToMany
    @JoinColumn(name = "eventId")
    List<Attendee> att;
    @OneToMany
    @JoinColumn(name = "eventId")
    List<Supplier> supplier;

    public Event() {
    }

    public Event(Builder build) {
        this.att = build.att;
        this.endDate = build.endDate;
        this.startDate = build.startDate;
        this.eventName = build.eventName;
        this.eventType = build.eventType;
        this.hostId = build.eventId;
        this.refundRate = build.refundRate;
        this.refundable = build.refundable;
        this.supplier = build.supplier;
        this.staff = build.staff;
        this.eventId = build.eventId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public long getHostId() {
        return hostId;
    }

    public void setHostId(long hostId) {
        this.hostId = hostId;
    }

    public String getRefundable() {
        return refundable;
    }

    public void setRefundable(String refundable) {
        this.refundable = refundable;
    }

    public double getRefundRate() {
        return refundRate;
    }

    public void setRefundRate(double refundRate) {
        this.refundRate = refundRate;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }

    public List<Attendee> getAtt() {
        return att;
    }

    public void setAtt(List<Attendee> att) {
        this.att = att;
    }

    public List<Supplier> getSupplier() {
        return supplier;
    }

    public void setSupplier(List<Supplier> supplier) {
        this.supplier = supplier;
    }

    public static class Builder {

        private Long eventId;
        private String eventName;
        private String eventType;
        private Calendar startDate;
        private Calendar endDate;
        private long hostId;
        private String refundable;
        private double refundRate;
        @OneToMany
        @JoinColumn(name = "eventId")
        List<Staff> staff;
        @OneToMany
        @JoinColumn(name = "eventId")
        List<Attendee> att;
        @OneToMany
        @JoinColumn(name = "eventId")
        List<Supplier> supplier;

        public Builder(String eventName) {
            this.eventName = eventName;
        }

        public Builder eventId(long eventId) {
            this.eventId = eventId;
            return this;
        }

        public Builder eventType(String eventType) {
            this.eventType = eventType;
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

        public Builder host(long host) {
            this.hostId = host;
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

        public Event build() {
            return new Event(this);
        }

        public Builder copier(Event ev) {
            this.att = ev.att;
            this.endDate = ev.endDate;
            this.startDate = ev.startDate;
            this.eventName = ev.eventName;
            this.eventType = ev.eventType;
            this.hostId = ev.eventId;
            this.refundRate = ev.refundRate;
            this.refundable = ev.refundable;
            this.supplier = ev.supplier;
            this.staff = ev.staff;
            this.eventId = ev.eventId;
            return this;

        }
    }

    public Long getId() {
        return eventId;
    }

    public void setId(Long eventId) {
        this.eventId = eventId;
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
