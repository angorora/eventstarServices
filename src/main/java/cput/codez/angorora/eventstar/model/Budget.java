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
public class Budget implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double venueCost;
    private double marketingCost;
    private double foodCost;
    private double audioVisualCost;
    private double staffCost;
    private double photographyCost;
    private double decorCost;
    private double securityCost;
    private double speakerCosts;
    private double transportCost;

    private Budget() {
    }

    private Budget(Builder build) {
        this.audioVisualCost = build.audioVisualCost;
        this.decorCost = build.decorCost;
        this.id = build.id;
        this.foodCost = build.foodCost;
        this.marketingCost = build.marketingCost;
        this.photographyCost = build.photographyCost;
        this.securityCost = build.securityCost;
        this.staffCost = build.staffCost;
        this.speakerCosts = build.speakerCosts;
        this.venueCost = build.venueCost;
        this.transportCost = build.transportCost;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

  public double getVenueCost() {
        return venueCost;
    }

    public double getMarketingCost() {
        return marketingCost;
    }

    public double getFoodCost() {
        return foodCost;
    }

    public double getAudioVisualCost() {
        return audioVisualCost;
    }

    public double getStaffCost() {
        return staffCost;
    }

    public double getPhotographyCost() {
        return photographyCost;
    }

    public double getDecorCost() {
        return decorCost;
    }

    public double getSecurityCost() {
        return securityCost;
    }

    public double getSpeakerCosts() {
        return speakerCosts;
    }

    public double getTransportCost() {
        return transportCost;
    }

    public static class Builder {

        private Long id;
        private double venueCost;
        private double marketingCost;
        private double foodCost;
        private double audioVisualCost;
        private double staffCost;
        private double photographyCost;
        private double decorCost;
        private double securityCost;
        private double speakerCosts;
        private double transportCost;

        
        public Builder(double venueCost) {
            this.venueCost = venueCost;
        }
        public Builder id(long id) {
            this.id = id;
            return this;
        }
        public Builder marketingCost(double marketCost) {
            this.marketingCost = marketCost;
            return this;
        }

        public Builder foodCost(double foodCost) {
            this.foodCost = foodCost;
            return this;
        }

        public Builder audioVisualCost(double avsCost) {
            this.audioVisualCost = avsCost;
            return this;
        }

        public Builder staffCost(double staffCost) {
            this.staffCost = staffCost;
            return this;
        }

        public Builder photo(double photoCost) {
            this.photographyCost = photoCost;
            return this;
        }

        public Builder decor(double decor) {
            this.decorCost = decor;
            return this;
        }

        public Builder security(double security) {
            this.securityCost = security;
            return this;
        }

        public Builder speaker(double speaker) {
            this.speakerCosts = speaker;
            return this;
        }

        public Builder transport(double transport) {
            this.transportCost = transport;
            return this;
        }

        public Budget build() {
            return new Budget(this);
        }

        public Builder copier(Budget budget) {
            this.audioVisualCost = budget.audioVisualCost;
            this.decorCost = budget.decorCost;
            this.id = budget.id;
            this.foodCost = budget.foodCost;
            this.marketingCost = budget.marketingCost;
            this.photographyCost = budget.photographyCost;
            this.securityCost = budget.securityCost;
            this.staffCost = budget.staffCost;
            this.speakerCosts = budget.speakerCosts;
            this.venueCost = budget.venueCost;
            this.transportCost = budget.transportCost;
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
        if (!(object instanceof Budget)) {
            return false;
        }
        Budget other = (Budget) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cput.codez.angorora.eventstar.model.Budget[ id=" + id + " ]";
    }

}
