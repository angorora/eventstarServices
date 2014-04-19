/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.eventstar.model;

import javax.persistence.Embeddable;

/**
 *
 * @author marc
 */
@Embeddable
class Contact {

    private String telno;
    private String cellNo;
    private String email;
    private String webaddress;

    public Contact() {
    }

    public Contact(Builder build) {
        this.cellNo = build.cellNo;
        this.email = build.email;
        this.telno = build.telno;
        this.webaddress = build.webaddress;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public String getCellNo() {
        return cellNo;
    }

    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebaddress() {
        return webaddress;
    }

    public void setWebaddress(String webaddress) {
        this.webaddress = webaddress;
    }

    public static class Builder {

        private String telno;
        private String cellNo;
        private String email;
        private String webaddress;

        public Builder(String cell) {
            this.cellNo = cell;
        }

        public Builder telno(String telno) {
            this.telno = telno;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder webaddress(String web) {
            this.webaddress = web;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }

        public Builder copier(Contact cont) {
            this.cellNo = cont.cellNo;
            this.email = cont.email;
            this.telno = cont.telno;
            this.webaddress = cont.webaddress;
            return this;
        }
    }
}
