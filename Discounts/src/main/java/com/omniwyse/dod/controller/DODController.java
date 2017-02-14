package com.omniwyse.dod.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.omniwyse.dod.bean.DataResult;
import com.omniwyse.dod.bean.OtpBean;
import com.omniwyse.dod.dao.RegisterationValidateDao;
import com.omniwyse.dod.model.CategorySelection;
import com.omniwyse.dod.model.ConsumerLogin;
import com.omniwyse.dod.model.ConsumerLoginwithEmail;
import com.omniwyse.dod.model.ConsumerLoginwithMobile;
import com.omniwyse.dod.model.ConsumerProfile;
import com.omniwyse.dod.model.IdBasePromotion;
import com.omniwyse.dod.model.MerchantLogin;
import com.omniwyse.dod.model.MerchantLoginwithEmail;
import com.omniwyse.dod.model.MerchantLoginwithMobile;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.OTPValidation;
import com.omniwyse.dod.model.Promotion;
import com.omniwyse.dod.model.RegisterWithOtp;
import com.omniwyse.dod.service.LoginService;
import com.omniwyse.dod.service.PromotionService;
import com.omniwyse.dod.service.RegistrationService;
import com.omniwyse.dod.service.ValidationService;

@RestController
public class DODController {	
	
	@Autowired
	RegistrationService registrationService;
	@Autowired
	LoginService loginService;
	@Autowired
	RegisterationValidateDao ConsumerRegisterValidate;	
	@Autowired
	ValidationService validationService;
	@Autowired
	PromotionService promotionService;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity SavewithOTP(@RequestBody RegisterWithOtp registerWithOtp) {
		RegisterWithOtp data=ConsumerRegisterValidate.getmobileno(registerWithOtp);
		if (data==null) {			
			Integer otp=1234;			
			OtpBean otpBean=new OtpBean("OTP For Registration !!", otp);
			RegisterWithOtp model = registrationService.Register(registerWithOtp);			
			return new ResponseEntity(otpBean, HttpStatus.OK);
			}
		else{
			DataResult result=new DataResult(false, " Sorry Mobile no is already exist ... ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
			}	
	}	
	/*======================================================================================================*/	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/OTPvalidate", method = RequestMethod.POST)
	public ResponseEntity getOTP(@RequestBody OTPValidation oTPValidation) {
		RegisterWithOtp data=validationService.Getotp(oTPValidation);
		if (data!=null) {		
			DataResult result=new DataResult(true, " OTP Validation successfully ... ", HttpStatus.OK.value());	
			return new ResponseEntity(result , HttpStatus.OK);			
			}
		else{
			DataResult result=new DataResult(false, "Sorry , Wrong OTP No / Mobile no . ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
			}	
	}	
	/*======================================================================================================*/			
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/consumerRegistration", method = RequestMethod.POST)
	public ResponseEntity Registerconsumer(@RequestBody ConsumerProfile consumerProfile) {		
		ConsumerProfile data=ConsumerRegisterValidate.getmobilenoandemail(consumerProfile);			
		if (data == null) {
			ConsumerProfile model = registrationService.registerconsumer(consumerProfile);
			DataResult result=new DataResult(true, " Consumer Registration successfully ...", HttpStatus.OK.value());
			return new ResponseEntity(result, HttpStatus.OK);			
		} else {
			DataResult result=new DataResult(false, " Sorry , Mobile no and Mail address is alredy exist !!", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);	
		}	
	}
	/*======================================================================================================*/	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/consumerlogin", method = RequestMethod.POST)
	public ResponseEntity checkMobile(@RequestBody ConsumerLogin userLogin) {
		RegisterWithOtp	 resp=loginService.ConsumerLogin(userLogin);
		if (resp!=null) {
			DataResult result=new DataResult(true, " Login Succes ... ", HttpStatus.OK.value());
			return new ResponseEntity(result, HttpStatus.OK); 			
		}
		else {
			DataResult result=new DataResult(false, " Sorry , Wrong Credentials ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
		}		
	}	
	/*======================================================================================================*/	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/consumeremaillogin", method = RequestMethod.POST)
	public ResponseEntity checkUsernameAndPassword(@RequestBody ConsumerLoginwithEmail userLogin) {
		ConsumerProfile resp=loginService.consumerautheticatewithemail(userLogin);			
		if (resp!=null){
			DataResult result=new DataResult(true, " Login Succes ... ", HttpStatus.OK.value());
			return new ResponseEntity(result, HttpStatus.OK);
		}else{
			DataResult result=new DataResult(false, " Sorry , Wrong Credentials ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);			
		}		
	}
	/*======================================================================================================*/	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/consumermobilelogin", method = RequestMethod.POST)
	public ResponseEntity checkUsernameAndPassword(@RequestBody ConsumerLoginwithMobile userLogin) {
		ConsumerProfile resp=loginService.consumerautheticatewithMobile(userLogin);	
		if (resp!=null)  {
			DataResult result=new DataResult(true, " Login Succes ... ", HttpStatus.OK.value());
			return new ResponseEntity(result, HttpStatus.OK);
		}else{
			DataResult result=new DataResult(false, " Sorry , Wrong Credentials ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);			
		}		
	}	
	/*======================================================================================================*/	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/merchantRegistration", method = RequestMethod.POST)
	public ResponseEntity Registermerchant(@RequestBody MerchantProfile merchantProfile) {		
		MerchantProfile data=ConsumerRegisterValidate.getmobilenoandemail(merchantProfile);			
		if (data == null) {			
			MerchantProfile model = registrationService.registermerchant(merchantProfile);
			DataResult result=new DataResult(true, " Merchant Registration successfully ...", HttpStatus.OK.value());
			return new ResponseEntity(result,HttpStatus.OK);			
		}else {
			DataResult result=new DataResult(false, "Sorry , Mobile no and Mail address is alredy exist !!", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
		}	
	}	
	/*======================================================================================================*/		
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/merchantlogin", method = RequestMethod.POST)
	public ResponseEntity checkMerchatUsernameAndPassword(@RequestBody MerchantLogin merchantLogin) {
		MerchantProfile resp=loginService.MerchatLogin(merchantLogin);
		if (resp!=null) {			
			DataResult result=new DataResult(true, " Login Succes ... ", HttpStatus.OK.value());
			return new ResponseEntity(result, HttpStatus.OK);
		}
		else {
			DataResult result=new DataResult(false, " Sorry , Wrong Credentials ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
		}		
	}
	/*======================================================================================================*/	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/merchantemaillogin", method = RequestMethod.POST)
	public ResponseEntity checkUsernameAndPassword(@RequestBody MerchantLoginwithEmail merchantLoginwithEmail) {
		MerchantProfile resp=loginService.merchatAutheticateWithEmail(merchantLoginwithEmail);	
		if (resp!=null)  {
			DataResult result=new DataResult(true, " Login Succes ... ", HttpStatus.OK.value());
			return new ResponseEntity(result, HttpStatus.OK);
		}else{
			DataResult result=new DataResult(false, " Sorry , Wrong Credentials ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);	
		}		
	}	
	/*======================================================================================================*/	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/merchantmobilelogin", method = RequestMethod.POST)
	public ResponseEntity checkUsernameAndPassword(@RequestBody MerchantLoginwithMobile merchantLoginwithMobile) {
		MerchantProfile resp=loginService.merchatAutheticateWithMobile(merchantLoginwithMobile);
		if (resp!=null)  {
			DataResult result=new DataResult(true, " Login Succes ... ", HttpStatus.OK.value());
			return new ResponseEntity(result, HttpStatus.OK);
		}else{
			DataResult result=new DataResult(false, " Sorry , Wrong Credentials ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);			
		}		
	}	
	/*======================================================================================================*/	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/promotions", method = RequestMethod.GET)
	public ResponseEntity getPromotions() {
		Date date=new Date();
		List<Promotion> promotions = promotionService.getPromotions(date);
		if (!promotions.isEmpty()) {
			
			return new ResponseEntity(promotions, HttpStatus.OK);			
		}else
		{
			DataResult result=new DataResult(false, "Sorry , No Promotions are available right now ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
		}	 
	}	
	/*======================================================================================================*/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/createpromotions", method = RequestMethod.POST)
	public ResponseEntity CreatePromotions(@RequestBody Promotion promotion) {		
		Promotion promotions = promotionService.CreatePromotions(promotion);
		if (promotions!=null) {
		DataResult result=new DataResult(true, " Promotion Posted successfully ... ", HttpStatus.OK.value());
		return new ResponseEntity(result, HttpStatus.OK);			
		}else
		{
			DataResult result=new DataResult(false, "Sorry , Please enter Valid data !! ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
		}	 
	}	
	/*======================================================================================================*/	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/categorypromotions", method = RequestMethod.POST)
	public ResponseEntity getCategoryPromotion(@RequestBody CategorySelection categorySelection) {
		Date date=new Date();
		List<Promotion> promotions = promotionService.getCategoryPromotions(date, categorySelection);
		if (!promotions.isEmpty()) {			
			return new ResponseEntity(promotions, HttpStatus.OK);			
		}else{			
			DataResult result=new DataResult(false, " Sorry , No Promotions are available on selected category right now ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
		}	
	}
	
	/*===========================================================================================================*/
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/IdBasePromotions", method = RequestMethod.POST)
	public ResponseEntity getIdbasePromotions(@RequestBody IdBasePromotion idBasePromotion) {		
		Promotion promotions = promotionService.IdBasePromotions(idBasePromotion);
		if (promotions!=null) {			
			return new ResponseEntity(promotions, HttpStatus.OK);			
		}else
		{
			DataResult result=new DataResult(false, "Sorry , No Promotions are available on selected id ... ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
		}	 
	}
	
	/*===========================================================================================================*/	
	
}
