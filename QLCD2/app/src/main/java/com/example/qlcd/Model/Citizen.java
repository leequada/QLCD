package com.example.qlcd.Model;

import java.io.Serializable;

public class Citizen implements Serializable {
     String name ;
     String cmnd ;
    String sex;
    String  dob;
    String country ;
    String hokhau ;
    String  home ;
    String fathername;
    String mothername;
    String wifename;
    String dobfather;

    public void setName(String name) {
        this.name = name;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setHokhau(String hokhau) {
        this.hokhau = hokhau;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public void setMothername(String mothername) {
        this.mothername = mothername;
    }

    public void setWifename(String wifename) {
        this.wifename = wifename;
    }

    public void setDobfather(String dobfather) {
        this.dobfather = dobfather;
    }

    public void setDobmother(String dobmother) {
        this.dobmother = dobmother;
    }

    public void setDobwife(String dobwife) {
        this.dobwife = dobwife;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCriminal(String criminal) {
        this.criminal = criminal;
    }

    public void setNote(String note) {
        this.note = note;
    }

    String dobmother;
    String dobwife;
    String phone;
    String criminal;
    String note;

    public Citizen(String name, String cmnd, String sex, String dob, String country, String hokhau, String home, String fathername, String mothername, String wifename, String dobfather, String dobmother, String dobwife, String phone, String criminal, String note) {
        this.name = name;
        this.cmnd = cmnd;
        this.sex = sex;
        this.dob = dob;
        this.country = country;
        this.hokhau = hokhau;
        this.home = home;
        this.fathername = fathername;
        this.mothername = mothername;
        this.wifename = wifename;
        this.dobfather = dobfather;
        this.dobmother = dobmother;
        this.dobwife = dobwife;
        this.phone = phone;
        this.criminal = criminal;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public String getCmnd() {
        return cmnd;
    }

    public String getSex() {
        return sex;
    }

    public String getDob() {
        return dob;
    }

    public String getCountry() {
        return country;
    }

    public String getHokhau() {
        return hokhau;
    }

    public String getHome() {
        return home;
    }

    public String getFathername() {
        return fathername;
    }

    public String getMothername() {
        return mothername;
    }

    public String getWifename() {
        return wifename;
    }

    public String getDobfather() {
        return dobfather;
    }

    public String getDobmother() {
        return dobmother;
    }

    public String getDobwife() {
        return dobwife;
    }

    public String getPhone() {
        return phone;
    }

    public String getCriminal() {
        return criminal;
    }

    public String getNote() {
        return note;
    }
}
