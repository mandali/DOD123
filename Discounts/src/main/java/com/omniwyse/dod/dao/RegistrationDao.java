package com.omniwyse.dod.dao;

import com.omniwyse.dod.model.RegisterWithOtp;
import com.omniwyse.dod.model.UserProfile;

public interface RegistrationDao {
	
	public RegisterWithOtp register(RegisterWithOtp registerWithOtp); 
	
	public UserProfile registeruser(UserProfile userProfile);
	
}
