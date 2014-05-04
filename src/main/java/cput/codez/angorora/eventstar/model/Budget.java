/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.eventstar.model;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author marc
 */
@Embeddable
public class Budget implements Serializable {

    private static final long serialVersionUID = 1L;
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
        this.foodCost = build.foodCost;
        this.marketingCost = build.marketingCost;
        this.photographyCost = build.photographyCost;
        this.securityCost = build.securityCost;
        this.staffCost = build.staffCost;
        this.speakerCosts = build.speakerCosts;
        this.venueCost = build.venueCost;
        this.transportCost = build.transportCost;
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

}
