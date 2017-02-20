package com.omniwyse.dod.service;

import com.omniwyse.dod.model.RegisterWithOtp;
import com.omniwyse.dod.model.UserProfile;

public interface RegistrationService {	
		
	public RegisterWithOtp Register(RegisterWithOtp registerWithOtp);
	
	public UserProfile registeruser(UserProfile userProfile);
	
}
