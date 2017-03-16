package com.omniwyse.dod.model;


import java.io.Serializable;

/**
 * Created by surya on 3/14/2017.
 */

public class BeaconRequestData implements Serializable{
    private String beaconUID;
    private String beaconMinorValue;
    private String beaconMajorValue;

    public String getBeaconUID() {
        return beaconUID;
    }

    public void setBeaconUID(String beaconUID) {
        this.beaconUID = beaconUID;
    }

    public String getBeaconMinorValue() {
        return beaconMinorValue;
    }

    public void setBeaconMinorValue(String beaconMinorValue) {
        this.beaconMinorValue = beaconMinorValue;
    }

    public String getBeaconMajorValue() {
        return beaconMajorValue;
    }

    public void setBeaconMajorValue(String beaconMajorValue) {
        this.beaconMajorValue = beaconMajorValue;
    }

}
