package com.example.cardiacrecorder.Domain;

import androidx.annotation.NonNull;

public class ListDomain {
    private String systolic_pressure;
    private String diastolic_pressure;
    private String date;
    private String time;

    private String key;

    public ListDomain(String systolic_pressure, String diastolic_pressure, String date, String time, String key, String n1) {
        this.systolic_pressure = systolic_pressure;
        this.diastolic_pressure = diastolic_pressure;
        this.date = date;
        this.time = time;
        this.key = key;
        this.n1 = n1;
    }

    public String getN1() {
        return n1;
    }

    public void setN1(String n1) {
        this.n1 = n1;
    }

    private String n1;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ListDomain(String systolic_pressure, String diastolic_pressure, String date, String time, String key) {
        this.systolic_pressure = systolic_pressure;
        this.diastolic_pressure = diastolic_pressure;
        this.date = date;
        this.time = time;
        this.key = key;
    }

    public String getSystolic_pressure() {
        return systolic_pressure;
    }

    public void setSystolic_pressure(String systolic_pressure) {
        this.systolic_pressure = systolic_pressure;
    }

    public String getDiastolic_pressure() {
        return diastolic_pressure;
    }

    public void setDiastolic_pressure(String diastolic_pressure) {
        this.diastolic_pressure = diastolic_pressure;
    }

//    public ListDomain(String systolic_pressure, String diastolic_pressure, String date, String time) {
//        this.systolic_pressure = systolic_pressure;
//        this.diastolic_pressure = diastolic_pressure;
//        this.date = date;
//        this.time = time;
//    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }





}
