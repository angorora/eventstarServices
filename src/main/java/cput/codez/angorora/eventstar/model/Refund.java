/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.eventstar.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author marc
 */
@Entity
public class Refund implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long attendeeId;
    private double amount;
    @Temporal(TemporalType.DATE)
    private Calendar dateOfrefund=new GregorianCalendar();
    private String acountNumber;
    private String bankName;
    private String branchCode;

    private Refund() {
    }

    private Refund(Builder builder) {
      this.acountNumber=builder.acountNumber;
      this.amount=builder.amount;
      this.attendeeId=builder.attendeeId;
      this.bankName=builder.bankName;
      this.branchCode=builder.branchCode;
      this.dateOfrefund=builder.dateOfRefund;
      this.id=builder.id;
    }

    public long getAttendeeId() {
        return attendeeId;
    }

    public double getAmount() {
        return amount;
    }

    public Calendar getDateOfrefund() {
        return dateOfrefund;
    }

    public String getAcountNumber() {
        return acountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public static class Builder {

        private Long id;
        private long attendeeId;
        private double amount;
        private Calendar dateOfRefund=new GregorianCalendar();
        private String acountNumber;
        private String bankName;
        private String branchCode;

        public Builder(long attendeeId){
            this.attendeeId=attendeeId;
        }
        public Builder id(Long id){
            this.id=id;
            return this;
        }
        public Builder amount(double amnt){
            this.amount=amnt;
            return this;
        }
        public Builder dateOfRefund(Calendar refund){
            this.dateOfRefund=refund;
            return this;
        }
        public Builder accountNumber(String acc){
            this.acountNumber=acc;
            return this;
        }
        public Builder bankName(String bname){
            this.bankName=bname;
            return this;
        }
        public Builder branchCode(String branchCode){
            this.branchCode=branchCode;
            return this;
        }
        public Refund build(){
            return new Refund(this);
        }
        public Builder copier(Refund ref){
            this.id=ref.id;
            this.acountNumber=ref.acountNumber;
            this.amount=ref.amount;
            this.attendeeId=ref.attendeeId;
            this.bankName=ref.bankName;
            this.dateOfRefund=ref.dateOfrefund;
            this.branchCode=ref.branchCode;
            return this;
        }
    
    }

    public Long getId() {
        return id;
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
        if (!(object instanceof Refund)) {
            return false;
        }
        Refund other = (Refund) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cput.codez.angorora.eventstar.model.Refund[ id=" + id + " ]";
    }

}
