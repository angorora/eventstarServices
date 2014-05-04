/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.eventstar.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author marc
 */
@Embeddable
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    private double amount;

    private Payment() {
    }

    private Payment(Builder build) {
        this.amount = build.amount;
    }

    public double getAmount() {
        return amount;
    }

    public static class Builder {

        private double amount;

        public Builder(double amount) {
            this.amount = amount;
        }

        public Payment build() {
            return new Payment(this);
        }

        public Builder copier(Payment pay) {
            this.amount = pay.amount;
            return this;
        }
    }
}
