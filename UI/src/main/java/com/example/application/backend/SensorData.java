package com.example.application.backend;

import java.time.Instant;

public class SensorData {
    private String siteId;
    private String locationId;
    private String sensorCategory;
    private String sensorAttribute;
    private String unit;
    private Instant time;
    private double value;

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getSensorCategory() {
        return sensorCategory;
    }

    public void setSensorCategory(String sensorCategory) {
        this.sensorCategory = sensorCategory;
    }

    public String getSensorAttribute() {
        return sensorAttribute;
    }

    public void setSensorAttribute(String sensorAttribute) {
        this.sensorAttribute = sensorAttribute;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    
}