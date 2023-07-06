package com.example.cardiacrecorder;

public class PressureData {
    public String key;
    public String systolicPressure;
    public String diastolicPressure;
    public String currentDate;
    public String currentTime;

    /**
     * Default constructor required for calls to DataSnapshot.getValue(PressureData.class).
     */
    public PressureData() {
        // Default constructor required for calls to DataSnapshot.getValue(PressureData.class)
    }


    /**
     * Constructs a new instance of the PressureData class with the specified parameters.
     *
     * @param key               The key associated with the pressure data.
     * @param systolicPressure  The systolic pressure value.
     * @param diastolicPressure The diastolic pressure value.
     * @param currentDate       The current date.
     * @param currentTime       The current time.
     */

    public PressureData(String key, String systolicPressure, String diastolicPressure, String currentDate, String currentTime) {
        this.key = key;
        this.systolicPressure = systolicPressure;
        this.diastolicPressure = diastolicPressure;
        this.currentDate = currentDate;
        this.currentTime = currentTime;
    }
}
