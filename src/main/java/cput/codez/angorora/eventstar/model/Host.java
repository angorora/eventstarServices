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
public class Host implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String hostName;
    @Embedded
    private Contact contact;
    private Host() {
    }

    private Host(Builder build) {
        this.hostName = build.hostName;
        this.id = build.id;
        this.contact = build.contact;
      
    }

   
    public String getHostName() {
        return hostName;
    }

    public Contact getContact() {
        return contact;
    }

    public static class Builder {

        private Long id;
        private String hostName;
        @Embedded
        private Contact contact;
       

        public Builder(String hostName) {
            this.hostName = hostName;
        }

        public Builder contact(Contact cont) {
            this.contact = cont;
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
            this.id = host.id;
            this.contact = host.contact;
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
        if (!(object instanceof Host)) {
            return false;
        }
        Host other = (Host) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cput.codez.angorora.eventstar.model.Host[ id=" + id + " ]";
    }

}
