package com.example.cardiacrecorder;

public class PressureData {
    public String key;
    public String systolicPressure;
    public String diastolicPressure;
    public String currentDate;
    public String currentTime;
    public PressureData() {
        // Default constructor required for calls to DataSnapshot.getValue(PressureData.class)
    }
    public PressureData(String key, String systolicPressure, String diastolicPressure, String currentDate, String currentTime) {
        this.key = key;
        this.systolicPressure = systolicPressure;
        this.diastolicPressure = diastolicPressure;
        this.currentDate = currentDate;
        this.currentTime = currentTime;
    }
}
