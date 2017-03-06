package com.omniwyse.dod.api;

/**
 * Created by Mukesh on 01-02-2017.
 */

public class Otpbodyrequest {

    final String mobile;
    final String otp;


    public Otpbodyrequest(String mobile, String otp) {
        this.mobile = mobile;
        this.otp = otp;

    }
}
