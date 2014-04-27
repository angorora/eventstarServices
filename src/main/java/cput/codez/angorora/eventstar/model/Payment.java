/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.eventstar.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author marc
 */
@Entity
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentId;
    private double amount;

    private Payment() {
    }

    private Payment(Builder build) {
        this.amount = build.amount;
        this.paymentId = build.paymentId;
    }

    public Long getPaymentId() {
        return paymentId;
    }

 

  

    public double getAmount() {
        return amount;
    }

    

     public static class Builder {

        private Long paymentId;
     
        private double amount;

      
        public Builder paymentId(long paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder (double amount) {
            this.amount =amount;
          
        }

        public Payment build() {
            return new Payment(this);
        }

        public Builder copier(Payment pay) {
            this.amount = pay.amount;
            this.paymentId = pay.paymentId;
            return this;
        }
    }

    public Long getId() {
        return paymentId;
    }

    public void setId(Long paymentId) {
        this.paymentId = paymentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentId != null ? paymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the paymentId fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.paymentId == null && other.paymentId != null) || (this.paymentId != null && !this.paymentId.equals(other.paymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cput.codez.angorora.eventstar.model.Payment[ paymentId=" + paymentId + " ]";
    }

}
