package com.example.memorymed.model;

import java.sql.Time;
import java.util.Date;

/**
 * Created by Cameron on 2/5/2015.
 */
public class Appointment {

    private String name;
    private Doctor doctor;
    private Date date;
    private Time time;
    private String address;
    //private Time reminderTime;
    private String notes;

    public Appointment(String name, Doctor doctor, Date date, String address, Time time, String notes) {
        this.name = name;
        this.doctor = doctor;
        this.date = date;
        this.address = address;
        this.time = time;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
