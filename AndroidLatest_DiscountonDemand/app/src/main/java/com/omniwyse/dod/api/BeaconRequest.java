package com.omniwyse.dod.api;

import com.omniwyse.dod.model.BeaconRequestData;

import java.io.Serializable;
import java.util.List;

/**
 * Created by surya on 3/6/2017.
 */

public class BeaconRequest implements Serializable {

    private  final List<BeaconRequestData> beaconIds;

    public BeaconRequest(List<BeaconRequestData> beaconIds) {
        this.beaconIds = beaconIds;
    }

}
