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
import com.omni.dod.model.ConsumerProfile;
import com.omni.dod.model.MerchantLogin;
import com.omni.dod.model.MerchantProfile;
import com.omni.dod.model.Promotion;
import com.omni.dod.model.RegisterWithOtp;
import com.omni.dod.model.Category;
import com.omni.dod.model.CategorySelection;
import com.omni.dod.model.ConsumerLogin;
import com.omni.dod.model.UserProfile;
import com.omni.dod.service.LoginService;
import com.omni.dod.service.RegistrationService;

@RestController
public class DODController {
	
	@Autowired
	RegistrationService registrationService;
	@Autowired
	LoginService loginService;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity SavewithOTP(@RequestBody RegisterWithOtp registerWithOtp) {		
		Integer otp=1234;
		OtpBean otpBean=new OtpBean("OTP For Registration !!", otp);
		RegisterWithOtp model = registrationService.Register(registerWithOtp);
		
		return new ResponseEntity(otpBean, HttpStatus.OK);	
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/userRegistration", method = RequestMethod.POST)
	public ResponseEntity RegisterUser(@RequestBody UserProfile userProfile) {		
		UserProfile model = registrationService.registeruser(userProfile);
		//DataResult result=new DataResult(true, "Success", HttpStatus.OK.value());		
		return new ResponseEntity(model, HttpStatus.OK);		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/merchantRegistration", method = RequestMethod.POST)
	public ResponseEntity Registermerchant(@RequestBody MerchantProfile merchantProfile) {		
		MerchantProfile model = registrationService.registermerchant(merchantProfile);	
		//DataResult result=new DataResult(true, "Success", HttpStatus.OK.value());
		System.out.println(model);
		return new ResponseEntity(model, HttpStatus.OK);
	}		
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/consumerRegistration", method = RequestMethod.POST)
	public ResponseEntity Registerconsumer(@RequestBody ConsumerProfile consumerProfile) {			
		ConsumerProfile model = registrationService.registerconsumer(consumerProfile);	
		//DataResult result=new DataResult(true, "Success", HttpStatus.OK.value());
		System.out.println(model);
		return new ResponseEntity(model, HttpStatus.OK);
	}		
	
	@RequestMapping(value = "/promotions", method = RequestMethod.GET)
	public ResponseEntity getPromotions() {
		Date date=new Date();
		List<Promotion> promotions = registrationService.getPromotions(date);
		//DataResult result=new DataResult(true, "Success", HttpStatus.OK.value(),promotions);
		return new ResponseEntity(promotions, HttpStatus.OK); 
	}	
	
	@RequestMapping(value = "/categorypromotions", method = RequestMethod.POST)
	public ResponseEntity getCategoryPromotion(@RequestBody CategorySelection categorySelection) {
		Date date=new Date();
		List<Promotion> promotions = registrationService.getCategoryPromotions(date, categorySelection);
		if (!promotions.isEmpty()) {
			//DataResult result=new DataResult(true, "Success", HttpStatus.OK.value());
			return new ResponseEntity(promotions, HttpStatus.OK);
			
		}else{
			return new ResponseEntity(" Sorry , No Promotions On Selected Category", HttpStatus.BAD_REQUEST);
		}	
	}	
	
	@RequestMapping(value = "/consumerlogin", method = RequestMethod.POST)
	public ResponseEntity checkUsernameAndPassword(@RequestBody ConsumerLogin userLogin) {
		ConsumerProfile resp=loginService.autheticate(userLogin);
		if (resp!=null) {
			return new ResponseEntity("Login Succes !!  ", HttpStatus.OK); 			
		}
		else {
			return new ResponseEntity(" Sorry , Wrong Credentials ", HttpStatus.BAD_REQUEST);
		}		
	}	
	
	@RequestMapping(value = "/merchantlogin", method = RequestMethod.POST)
	public ResponseEntity checkMerchatUsernameAndPassword(@RequestBody MerchantLogin merchantLogin) {
		MerchantProfile resp=loginService.merchatAutheticate(merchantLogin);
		if (resp!=null) {
			return new ResponseEntity("Login Succes !!  ", HttpStatus.OK); 
		}
		else {
			return new ResponseEntity(" Sorry , Wrong Credentials ", HttpStatus.BAD_REQUEST);
		}		
	}	
}
