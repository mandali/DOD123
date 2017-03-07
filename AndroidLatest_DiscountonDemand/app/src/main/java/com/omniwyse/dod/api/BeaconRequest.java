package com.omniwyse.dod.api;

import java.util.List;

/**
 * Created by surya on 3/6/2017.
 */

public class BeaconRequest {

    private final List<String> beaconIds;


    public BeaconRequest(List<String> beaconIds) {
        this.beaconIds = beaconIds;
    }
}
