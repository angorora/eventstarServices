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
public class Host implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hostId;
    private String hostName;
    @Embedded
    private Contact contact;
    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name = "hostId")
    private List<Event> event;

    private Host() {
    }

    private Host(Builder build) {
        this.hostName = build.hostName;
        this.hostId = build.id;
        this.contact = build.contact;
        this.event=build.event;
    }

    public String getHostName() {
        return hostName;
    }

    public Contact getContact() {
        return contact;
    }

    public List<Event> getEvent() {
        return event;
    }

    public static class Builder {

        private Long id;
        private String hostName;
        @Embedded
        private Contact contact;
        private List<Event> event;

        public Builder(String hostName) {
            this.hostName = hostName;
        }

        public Builder contact(Contact cont) {
            this.contact = cont;
            return this;
        }

        public Builder event(List<Event> ev) {
            this.event = ev;
            return this;
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Host build() {
            return new Host(this);
        }

        public Builder copier(Host host) {
            this.hostName = host.hostName;
            this.id = host.hostId;
            this.contact = host.contact;
            this.event=host.event;
            return this;
        }
    }

    public Long getHostId() {
        return hostId;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hostId != null ? hostId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the hostId fields are not set
        if (!(object instanceof Host)) {
            return false;
        }
        Host other = (Host) object;
        if ((this.hostId == null && other.hostId != null) || (this.hostId != null && !this.hostId.equals(other.hostId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cput.codez.angorora.eventstar.model.Host[ id=" + hostId + " ]";
    }

}
