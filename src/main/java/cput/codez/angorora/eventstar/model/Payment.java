/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.eventstar.model;

import java.io.Serializable;
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
    private String status;
    private double balance;

    public Payment() {
    }

    public Payment(Builder build) {
        this.balance = build.balance;
        this.paymentId = build.paymentId;
        this.status = build.status;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static class Builder {

        private Long paymentId;
        private String status;
        private double balance;

        public Builder(long paymentId) {
            this.paymentId = paymentId;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder balance(double balance) {
            this.balance = balance;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }

        public Builder copier(Payment pay) {
            this.balance = pay.balance;
            this.paymentId = pay.paymentId;
            this.status = pay.status;
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
