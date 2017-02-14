package com.omni.dod.bean;

public class OtpBean {
	private String otpType;
	
	private Integer otp;

	public OtpBean() {
	}

	public OtpBean(String otpType, Integer otp) {
		super();
		this.otpType = otpType;
		this.otp = otp;
	}

	public String getOtpType() {
		return otpType;
	}

	public void setOtpType(String otpType) {
		this.otpType = otpType;
	}

	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
	}

}
