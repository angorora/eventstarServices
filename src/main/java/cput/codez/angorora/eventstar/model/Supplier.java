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
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long supplierId;
    private String supplierName;
    @Embedded
    private Contact contact;
    private String suppliedService;

    public Supplier() {
    }

    public Supplier(Builder build) {
        this.contact=build.contact;
        this.suppliedService=build.suppliedService;
        this.supplierId=build.supplierId;
        this.supplierName=build.supplierName;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getSuppliedService() {
        return suppliedService;
    }

    public void setSuppliedService(String suppliedService) {
        this.suppliedService = suppliedService;
    }

    public static class Builder {

        private Long supplierId;
        private String supplierName;
        @Embedded
        private Contact contact;
        private String suppliedService;
        public Builder(String supname){
            this.supplierName=supname;
        }
        public Builder supId(long supplierId){
            this.supplierId=supplierId;
            return this;
        }
        public Builder contact(Contact contact){
            this.contact=contact;
            return this;
        }
        public Builder supService(String supservice){
            this.suppliedService=supservice;
            return this;
        }
        public Supplier build(){
            return new Supplier(this);
        }
        public Builder copier(Supplier sup){
            this.contact=sup.contact;
            this.suppliedService=sup.suppliedService;
            this.supplierId=sup.supplierId;
            this.supplierName=sup.supplierName;
            return this;
        }
    }

    public Long getId() {
        return supplierId;
    }

    public void setId(Long supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supplierId != null ? supplierId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the supplierId fields are not set
        if (!(object instanceof Supplier)) {
            return false;
        }
        Supplier other = (Supplier) object;
        if ((this.supplierId == null && other.supplierId != null) || (this.supplierId != null && !this.supplierId.equals(other.supplierId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cput.codez.angorora.eventstar.model.Supplier[ supplierId=" + supplierId + " ]";
    }

}
