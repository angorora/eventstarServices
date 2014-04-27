/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.eventstar.model;

import java.util.Calendar;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author marc
 */
@Embeddable
public class Invitation {

    private String invitation;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar issueDate;

    private Invitation() {
    }

    private Invitation(Builder build) {
        this.invitation = build.invitation;
        this.issueDate = build.issueDate;
    }

    public String getInvitation() {
        return invitation;
    }

    public void setInvitation(String invitation) {
        this.invitation = invitation;
    }

    public Calendar getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Calendar issueDate) {
        this.issueDate = issueDate;
    }

    public static class Builder {

        private String invitation;
        private Calendar issueDate;

        public Builder(String invitation) {
            this.invitation = invitation;

        }

        public Builder issueDate(Calendar issuedate) {
            this.issueDate = issuedate;
            return this;
        }

        public Invitation build() {
            return new Invitation(this);
        }

        public Builder copier(Invitation invite) {
            this.invitation = invite.invitation;
            this.issueDate = invite.issueDate;
            return this;
        }

    }
}
