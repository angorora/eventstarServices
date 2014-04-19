/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.eventstar.model;

import java.util.Calendar;
import javax.persistence.Embeddable;

/**
 *
 * @author marc
 */
@Embeddable
public class Reminder {

    private String message;
    private Calendar activeDate;

    public Reminder() {
    }

    public Reminder(Builder build) {
        this.activeDate = build.activeDate;
        this.message = build.message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Calendar getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Calendar activeDate) {
        this.activeDate = activeDate;
    }

    public static class Builder {

        private String message;
        private Calendar activeDate;

        public Builder(String message) {
            this.message = message;
        }

        public Builder activeDate(Calendar active) {
            this.activeDate = active;
            return this;
        }

        public Reminder build() {
            return new Reminder(this);
        }

        public Builder copier(Reminder rem) {
            this.activeDate = rem.activeDate;
            this.message = rem.message;
            return this;
        }
    }
}
