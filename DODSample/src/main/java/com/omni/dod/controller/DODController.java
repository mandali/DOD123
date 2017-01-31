package com.omni.dod.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.omni.dod.bean.DataResult;
import com.omni.dod.bean.OtpBean;
import com.omni.dod.model.ConsumerRegistration;
import com.omni.dod.model.MerchantProfile;
import com.omni.dod.model.Promotions;
import com.omni.dod.model.RegisterWithOtp;
import com.omni.dod.model.UserProfile;
import com.omni.dod.service.RegistrationService;

@RestController
public class DODController {	
	@Autowired
	RegistrationService registrationService;	
	
	/*
	@RequestMapping(value = "/reg/consumer", method = RequestMethod.POST)
	public ResponseEntity saveConsumer(@RequestBody ConsumerRegistration consumerRegistration) {		
		System.out.println(consumerRegistration);
		ConsumerRegistration model = registrationService.save(consumerRegistration);
		DataResult<ConsumerRegistration> result=new DataResult(true, "Success", HttpStatus.OK.value(), model);
		return new ResponseEntity(result, HttpStatus.OK);
	}*/
	
	/*@RequestMapping(value = "/consumers", method = RequestMethod.GET)
	public ResponseEntity getConsumers() {
		List<ConsumerRegistration> consumerRegistrations = registrationService.getConsumers();;
		DataResult result=new DataResult(true, "Success", HttpStatus.OK.value(), consumerRegistrations);
		return new ResponseEntity(result, HttpStatus.OK);
	}*/	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity SavewithOTP(@RequestBody RegisterWithOtp registerWithOtp) {
		System.out.println(registerWithOtp);
		Integer otp=1234;
		OtpBean otpBean=new OtpBean("OTP For Registration !!", otp);
		RegisterWithOtp model = registrationService.Register(registerWithOtp);
		
		return new ResponseEntity(otpBean, HttpStatus.OK);	
	}	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/userRegistration", method = RequestMethod.POST)
	public ResponseEntity RegisterUser(@RequestBody UserProfile userProfile) {		
		System.out.println(userProfile);
		UserProfile model = registrationService.registeruser(userProfile);		
		//DataResult result=new DataResult(true, "Success", HttpStatus.OK.value());
		System.out.println(model);
		return new ResponseEntity(model, HttpStatus.OK);		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/merchantRegistration", method = RequestMethod.POST)
	public ResponseEntity Registermerchant(@RequestBody MerchantProfile merchantProfile) {		
		System.out.println(merchantProfile);
		MerchantProfile model = registrationService.registermerchant(merchantProfile);	
		//DataResult result=new DataResult(true, "Success", HttpStatus.OK.value());
		System.out.println(model);
		return new ResponseEntity(model, HttpStatus.OK);
	}	

	@RequestMapping(value = "/promotions", method = RequestMethod.GET)
	public ResponseEntity getPromotions() {
		Date date=new Date();
		List<Promotions> promotions = registrationService.getPromotions(date);
		//DataResult result=new DataResult(true, "Success", HttpStatus.OK.value(), promotions);
		return new ResponseEntity(promotions, HttpStatus.OK);
	}		
	
}
