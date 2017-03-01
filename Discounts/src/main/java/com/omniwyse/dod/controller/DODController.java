package com.omniwyse.dod.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.omniwyse.dod.AppConstants.AppConstants;
import com.omniwyse.dod.DTO.CategoryBrandVO;
import com.omniwyse.dod.DTO.CategoryVO;
import com.omniwyse.dod.DTO.CitiesVO;
import com.omniwyse.dod.DTO.CountryVO;
import com.omniwyse.dod.DTO.CreatePromotionVo;
import com.omniwyse.dod.DTO.LocationsVO;
import com.omniwyse.dod.DTO.MercnantDTO;
import com.omniwyse.dod.DTO.ProductVO;
import com.omniwyse.dod.DTO.PromotionDto;
import com.omniwyse.dod.bean.DataResult;
import com.omniwyse.dod.bean.DataResultEntity;
import com.omniwyse.dod.bean.DataResultlist;
import com.omniwyse.dod.bean.OtpBean;
import com.omniwyse.dod.config.AppConfiguration;
import com.omniwyse.dod.dao.MerchantDao;
import com.omniwyse.dod.dao.PromotionsDao;
import com.omniwyse.dod.dao.RegisterationValidateDao;
import com.omniwyse.dod.model.Brand;
import com.omniwyse.dod.model.Category;
import com.omniwyse.dod.model.CategorySelection;
import com.omniwyse.dod.model.Cities;
import com.omniwyse.dod.model.ConsumerIdBaseProfile;
import com.omniwyse.dod.model.ConsumerLogin;
import com.omniwyse.dod.model.ConsumerLoginwithEmail;
import com.omniwyse.dod.model.ConsumerLoginwithMobile;
import com.omniwyse.dod.model.ConsumerProfile;
import com.omniwyse.dod.model.Country;
import com.omniwyse.dod.model.GetMerchantById;
import com.omniwyse.dod.model.GetMerchatProfile;
import com.omniwyse.dod.model.IdBasePromotion;
import com.omniwyse.dod.model.Location;
import com.omniwyse.dod.model.MerchantLogin;
import com.omniwyse.dod.model.MerchantLoginwithEmail;
import com.omniwyse.dod.model.MerchantLoginwithMobile;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.MerchantPromotions;
import com.omniwyse.dod.model.OTPValidation;
import com.omniwyse.dod.model.Promotion;
import com.omniwyse.dod.model.Promotionsummary;
import com.omniwyse.dod.model.RegisterWithOtp;
import com.omniwyse.dod.service.ConsumerService;
import com.omniwyse.dod.service.LocationService;
import com.omniwyse.dod.service.MerchantService;
import com.omniwyse.dod.service.MetaDataService;
import com.omniwyse.dod.service.PromotionService;
import com.omniwyse.dod.service.RegistrationService;
import com.omniwyse.dod.service.ValidationService;

@RestController
public class DODController {	
	
	@Autowired
	RegistrationService registrationService;
	@Autowired
	ConsumerService consumerService;
	@Autowired
	RegisterationValidateDao ConsumerRegisterValidate;	
	@Autowired
	ValidationService validationService;
	@Autowired
	PromotionService promotionService;
	@Autowired
	MerchantService MerchantService;
	@Autowired
	MerchantDao MerchantDao;
	@Autowired
	LocationService locationService;
	@Autowired
	MetaDataService metaDataService;	
	@Autowired
	PromotionsDao promotionsDao;
	
	
	
	private static final Logger logger = Logger.getLogger(AppConfiguration.class);	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity SavewithOTP(@RequestBody RegisterWithOtp registerWithOtp) {
		final String METHOD_NAME="SavewithOTP";
		ResponseEntity responseEntity = null;
		RegisterWithOtp data=ConsumerRegisterValidate.getmobileno(registerWithOtp);
		try {		
		if (data==null) {			
			Integer otp=1234;				
			OtpBean otpBean=new OtpBean("OTP For Registration !!", otp);
			RegisterWithOtp model = registrationService.Register(registerWithOtp);	
			DataResult data1=new DataResult(true, "success", HttpStatus.OK.value());
			return new ResponseEntity(otpBean, HttpStatus.OK);
			}
		else{
			DataResult dataResult=new DataResult(false, " Sorry , Mobile no is alredy exist ... ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(dataResult, HttpStatus.BAD_REQUEST);
			}
		 }catch(Exception exception){
			 logger.error("Exception in "+METHOD_NAME+""+exception.getMessage()); 		
		}
		return responseEntity;		
	}
	

	/*======================================================================================================*/	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/OTPvalidate", method = RequestMethod.POST)
	public ResponseEntity getOTP(@RequestBody OTPValidation oTPValidation) {
		final String METHOD_NAME="getOTP";
		ResponseEntity responseEntity = null;
		RegisterWithOtp data=validationService.Getotp(oTPValidation);
		try{
		if (data!=null) {		
			DataResult result=new DataResult(true, " OTP Validation successfully ... ", HttpStatus.OK.value());	
			return new ResponseEntity(result , HttpStatus.OK);			
			}
		else{
			DataResult result=new DataResult(false, "Sorry , Wrong OTP No / Mobile no . ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
			}
		}catch(Exception exception)
		{
			 logger.error("Exception in "+METHOD_NAME+""+exception.getMessage()); 	
		}
		return responseEntity;
	}	
	/*======================================================================================================*/			
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/consumerRegistration", method = RequestMethod.POST)
	public ResponseEntity Registerconsumer(@RequestBody ConsumerProfile consumerProfile) {
		final String METHOD_NAME="Registerconsumer";
		ResponseEntity responseEntity = null;
		ConsumerProfile data=ConsumerRegisterValidate.getmobilenoandemail(consumerProfile);	
		try{
		if (data == null) {
			ConsumerProfile model = consumerService.registerconsumer(consumerProfile);
			DataResult result=new DataResult(true, " Consumer Registration successfully ...", HttpStatus.OK.value());
			return new ResponseEntity(result, HttpStatus.OK);			
		} else {
			DataResult result=new DataResult(false, " Sorry , Mobile no and Mail address is alredy exist !!", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);	
		}
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage()); 
		}
		return responseEntity;
	}
	
	/*======================================================================================================*/	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/consumerlogin", method = RequestMethod.POST)
	public ResponseEntity checkMobile(@RequestBody ConsumerLogin userLogin) {
		final String METHOD_NAME="checkMobile";
		ResponseEntity responseEntity = null;
		RegisterWithOtp	 resp=consumerService.ConsumerLogin(userLogin);
		try{
		if (resp!=null) {
			DataResult result=new DataResult(true, " Login Succes ... ", HttpStatus.OK.value());
			return new ResponseEntity(result, HttpStatus.OK); 			
		}
		else {
			DataResult result=new DataResult(false, " Sorry , Wrong Credentials ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
		}
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}
		return responseEntity;
	}	
	
	/*======================================================================================================*/
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/consumerProfile", method = RequestMethod.POST)
	public ResponseEntity consumerProfile(@RequestBody ConsumerIdBaseProfile consumerIdBaseProfile) {
		final String METHOD_NAME="consumerProfile";
		ResponseEntity responseEntity = null;
		ConsumerProfile	 resp=consumerService.ConsumerProfile(consumerIdBaseProfile);
		try{
		if (resp!=null) {
			DataResultEntity<ConsumerProfile> data=new DataResultEntity<ConsumerProfile>(true, "Consumer Details is , ", HttpStatus.OK.value(), resp);
			return new ResponseEntity(data, HttpStatus.OK); 			
		}
		else {
			DataResult result=new DataResult(false, " Sorry , No data available on selected mobile no ... ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
		}
		}catch(Exception exception)
		{
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage()); 
		}
		return responseEntity;
		
	}
	
	/*======================================================================================================*/	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/consumeremaillogin", method = RequestMethod.POST)
	public ResponseEntity checkEmailAndPassword(@RequestBody ConsumerLoginwithEmail userLogin) {
		final String METHOD_NAME="checkEmailAndPassword";
		ResponseEntity responseEntity = null;
		ConsumerProfile resp=consumerService.consumerautheticatewithemail(userLogin);	
		try{
		if (resp!=null){
			DataResult result=new DataResult(true, " Login Succes ... ", HttpStatus.OK.value());
			return new ResponseEntity(result, HttpStatus.OK);
		}else{
			DataResult result=new DataResult(false, " Sorry , Wrong Credentials ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);			
		}
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}
		return responseEntity;
	}
	/*======================================================================================================*/	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/consumermobilelogin", method = RequestMethod.POST)
	public ResponseEntity checkMobilenoAndPassword(@RequestBody ConsumerLoginwithMobile userLogin) {
		final String METHOD_NAME="checkMobilenoAndPassword";
		ResponseEntity responseEntity = null;
		ConsumerProfile resp=consumerService.consumerautheticatewithMobile(userLogin);	
		try{
		if (resp!=null)  {
			DataResult result=new DataResult(true, " Login Succes ... ", HttpStatus.OK.value());
			return new ResponseEntity(result, HttpStatus.OK);
		}else{
			DataResult result=new DataResult(false, " Sorry , Wrong Credentials ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);			
		}
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}
		return responseEntity;
	}	
	/*======================================================================================================*/	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/merchantRegistration", method = RequestMethod.POST)
	public ResponseEntity registerMerchant(@RequestBody MerchantProfile merchantProfile) {
		final String METHOD_NAME="registerMerchant";
		ResponseEntity responseEntity = null;
		MerchantProfile data=ConsumerRegisterValidate.getmobilenoandemail(merchantProfile);	
		try{
		if (data == null) {			
			MerchantProfile model = MerchantService.registermerchant(merchantProfile);
			DataResultEntity<MerchantProfile> dataResult=new DataResultEntity<MerchantProfile>(true, "Registration successfully", HttpStatus.OK.value(),model);
			return new ResponseEntity(dataResult,HttpStatus.OK);			
		}else {
			DataResult result=new DataResult(false, "Sorry , Mobile no and Mail address is alredy exist !!", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
		}
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}
		return responseEntity;
	}	
	
	/*======================================================================================================*/	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/merchantProfile", method = RequestMethod.POST)
	public ResponseEntity merchatProfile(@RequestBody GetMerchatProfile GetMerchatProfile) {
		final String METHOD_NAME="merchatProfile";
		ResponseEntity responseEntity = null;
		MerchantProfile data=MerchantService.MerchatProfile(GetMerchatProfile);		
		try{
		if (data != null) {			
			MerchantProfile model = MerchantService.MerchatProfile(GetMerchatProfile);
			DataResultEntity<MerchantProfile> dataResult=new DataResultEntity<MerchantProfile>(true, "Success , Merchant Details found ", HttpStatus.OK.value(),model);
			return new ResponseEntity(dataResult,HttpStatus.OK);			
		}else {
			DataResult result=new DataResult(false, " Sorry , no details found on selected mobile no ... ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
		}
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}return responseEntity;
	}
	
	/*======================================================================================================*/	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/merchantlist", method = RequestMethod.GET)
	public ResponseEntity allMerchants() {
		final String METHOD_NAME="allMerchants";
		ResponseEntity responseEntity = null;
		List<MerchantProfile> data=MerchantService.AllMerchants();
		List<MercnantDTO> response=new ArrayList<MercnantDTO>();
		MercnantDTO mercnantDTO;
		try{
		if (!data.isEmpty()) {
			for(MerchantProfile response1:data) {
				mercnantDTO=new MercnantDTO();
				mercnantDTO.setId(response1.getId().toString());
				mercnantDTO.setFirstname(response1.getFirstname());
				mercnantDTO.setLastname(response1.getLastname());
				mercnantDTO.setEmailid(response1.getEmailid());
				mercnantDTO.setMobilenumber(response1.getMobilenumber());
				mercnantDTO.setBusinessname(response1.getBusinessname());
				mercnantDTO.setBusinessoffaddr(response1.getBusinessoffaddr());
				mercnantDTO.setLandlineno(response1.getLandlineno());
				mercnantDTO.setCity(response1.getCity());
				mercnantDTO.setState(response1.getState());				
				mercnantDTO.setStreet(response1.getStreet());
				mercnantDTO.setCountry(response1.getCountry());
				mercnantDTO.setTown(response1.getTown());				
				mercnantDTO.setZipcode(response1.getDescription());
				mercnantDTO.setTags(response1.getTags());
				mercnantDTO.setDescription(response1.getDescription());				
				mercnantDTO.setNickname(response1.getNickname());			
				mercnantDTO.setCreateddate(response1.getCreateddate());
				response.add(mercnantDTO);
			}
			DataResultlist<MercnantDTO> resp=new DataResultlist<MercnantDTO>(true, " all merchants details is ", HttpStatus.OK.value(), response);		
			return new ResponseEntity(resp,HttpStatus.OK);			
		}else {
			DataResult result=new DataResult(false, " Sorry , merchants are not found right now  ... ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
		}
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}
		return responseEntity;
	}	
	
	/*======================================================================================================*/	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/getmerchatbyMobile", method = RequestMethod.POST)
	public ResponseEntity getMerchatById(@RequestBody GetMerchantById getMerchantById) {
		final String METHOD_NAME="getMerchatById";
		ResponseEntity responseEntity = null;
		MerchantProfile data=MerchantService.GetmerchantMobile(getMerchantById);
		try{
		if (data != null) {	
			DataResultEntity<MerchantProfile> merchantProfile=new DataResultEntity<MerchantProfile>(true, " Succes ,  Merchant Details is  ", HttpStatus.OK.value(), data);
			
			return new ResponseEntity(merchantProfile,HttpStatus.OK);			
		}else {
			DataResult result=new DataResult(false, "Sorry , No details found on selected id ... ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
		}
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}
		return responseEntity;
	}
	
/*======================================================================================================*/	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/promotion/merchantid", method = RequestMethod.POST)
	public ResponseEntity merchantPromotions(@RequestBody MerchantPromotions MerchantPromotions) {
		final String METHOD_NAME="merchantPromotions";
		ResponseEntity responseEntity = null;
		Date date=new Date();
		List<MerchantProfile> data=MerchantService.MerchatPromotion(MerchantPromotions, date);	
		List<PromotionDto> promotionDtos=new ArrayList<PromotionDto>();
		PromotionDto promotionDto;
		try{
		if (!data.isEmpty()) {
			for (MerchantProfile response:data) {
				promotionDto=new PromotionDto();
				promotionDto.setId(response.getId());
				for(Promotion promotion:response.getPromotions()){
					promotionDto.setProduct_id(promotion.getProduct_id());					
					promotionDto.setProduct_id(promotion.getProduct_id());
					promotionDto.setProduct_image(promotion.getProduct_image());
					promotionDto.setOriginalPrice(promotion.getOriginalPrice());
					promotionDto.setDiscount(promotion.getDiscount());
					promotionDto.setStartdate(promotion.getStartdate());
					promotionDto.setEnddate(promotion.getEnddate());
					promotionDto.setLocation(promotion.getLocation());
					promotionDto.setMerchatId(promotion.getMerchatid());
				}
				promotionDto.setDescription(response.getDescription());
				promotionDto.setCreateddate(response.getCreateddate());
				promotionDtos.add(promotionDto);				
			}
			DataResultlist<PromotionDto> resp=new DataResultlist<PromotionDto>(true, " Promotions are ", HttpStatus.OK.value(), promotionDtos);			
			return new ResponseEntity(resp,HttpStatus.OK);			
		}else {
			DataResult result=new DataResult(false, "Sorry , No Promotion found on selected Merchantid ... ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
		}
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}return responseEntity;
	}
	
	/*======================================================================================================*/		
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/merchantlogin", method = RequestMethod.POST)
	public ResponseEntity checkMerchatUsernameAndPassword(@RequestBody MerchantLogin merchantLogin) {
		final String METHOD_NAME="checkMerchatUsernameAndPassword";
		ResponseEntity responseEntity = null;
		MerchantProfile resp=MerchantService.MerchatLogin(merchantLogin);
		try{
		if (resp!=null) {			
			MerchantProfile merchantProfile=MerchantDao.GetMerchant(merchantLogin);			
			MercnantDTO merchnantDTO=new MercnantDTO();			
			merchnantDTO.setId(merchantProfile.getId().toString());
			merchnantDTO.setFirstname(merchantProfile.getFirstname());
			merchnantDTO.setLastname(merchantProfile.getLastname());
			merchnantDTO.setEmailid(merchantProfile.getEmailid());
			merchnantDTO.setMobilenumber(merchantProfile.getMobilenumber());
			merchnantDTO.setBusinessname(merchantProfile.getBusinessname());
			merchnantDTO.setBusinessoffaddr(merchantProfile.getBusinessoffaddr());
			merchnantDTO.setLandlineno(merchantProfile.getLandlineno());
			merchnantDTO.setCity(merchantProfile.getCity());
			merchnantDTO.setState(merchantProfile.getState());
			merchnantDTO.setStreet(merchantProfile.getStreet());
			merchnantDTO.setCountry(merchantProfile.getCountry());
			merchnantDTO.setTown(merchantProfile.getTown());
			merchnantDTO.setDescription(merchantProfile.getDescription());
			merchnantDTO.setTags(merchantProfile.getTags());
			merchnantDTO.setZipcode(merchantProfile.getZipcode());
			merchnantDTO.setNickname(merchantProfile.getNickname());
			merchnantDTO.setCreateddate(merchantProfile.getCreateddate());			
			DataResultEntity<MercnantDTO> result=new DataResultEntity<MercnantDTO>(true, " Login successfully ... ", HttpStatus.OK.value(),merchnantDTO);
			return new ResponseEntity(result, HttpStatus.OK);
		}
		else {
			DataResult result=new DataResult(false, " Sorry , Wrong Credentials ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
		}
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}
		return responseEntity;
	}
	/*======================================================================================================*/	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/merchantemaillogin", method = RequestMethod.POST)
	public ResponseEntity checkEmailAndPassword(@RequestBody MerchantLoginwithEmail merchantLoginwithEmail) {
		final String METHOD_NAME="checkEmailAndPassword";
		ResponseEntity responseEntity = null;
		MerchantProfile resp=MerchantService.merchatAutheticateWithEmail(merchantLoginwithEmail);
		try{
		if (resp!=null)  {
			DataResult result=new DataResult(true, " Login Succes ... ", HttpStatus.OK.value());
			return new ResponseEntity(result, HttpStatus.OK);
		}else{
			DataResult result=new DataResult(false, " Sorry , Wrong Credentials ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);	
		}
		}
		catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}
		return responseEntity;
	}	
	/*======================================================================================================*/	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/merchantmobilelogin", method = RequestMethod.POST)
	public ResponseEntity checkMobileAndPassword(@RequestBody MerchantLoginwithMobile merchantLoginwithMobile) {
		final String METHOD_NAME="checkMobileAndPassword";
		ResponseEntity responseEntity = null;
		MerchantProfile resp=MerchantService.merchatAutheticateWithMobile(merchantLoginwithMobile);
		try{
		if (resp!=null)  {
			DataResult result=new DataResult(true, " Login Succes ... ", HttpStatus.OK.value());
			return new ResponseEntity(result, HttpStatus.OK);
		}else{
			DataResult result=new DataResult(false, " Sorry , Wrong Credentials ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);			
		}
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}
		return responseEntity;
		
	}	
	/*======================================================================================================*/
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/promotions", method = RequestMethod.GET)
	public ResponseEntity getPromotions() {	
		final String METHOD_NAME="getPromotions";
		ResponseEntity responseEntity = null;
		Calendar calendar=Calendar.getInstance();
		Date date =  calendar.getTime();
		//java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		List<Promotion> promotions = promotionService.getPromotions();
		List<PromotionDto> promotionDtos=new ArrayList<PromotionDto>();
		PromotionDto promotionDto;
		try{
		if (!promotions.isEmpty()) {
			for (Promotion resp:promotions) {
				promotionDto=new PromotionDto();
				promotionDto.setId(resp.getId());
				promotionDto.setProduct_id(resp.getProduct_id());
				promotionDto.setDescription(resp.getDescription());
				promotionDto.setMerchatId(resp.getMerchatid());
				promotionDto.setProduct_image(resp.getProduct_image());
				promotionDto.setOriginalPrice(resp.getOriginalPrice());
				promotionDto.setDiscount(resp.getDiscount());
				promotionDto.setLocation(resp.getLocation());
				promotionDto.setCreateddate(resp.getCreateddate());
				promotionDto.setStartdate(resp.getStartdate());
				promotionDto.setEnddate(resp.getEnddate());
				promotionDto.setCategoryName(resp.getCatid().getCategoryName());
				promotionDto.setBrandName(resp.getBrandId().getBrandName());
				promotionDto.setBrandRating(resp.getBrandId().getBrandRating());
				promotionDto.setBrandImage(resp.getBrandId().getBrandImage());
				promotionDto.setBrandDescription(resp.getBrandId().getBrandDescription());
				promotionDto.setCatid(resp.getCatid().getCategoryId());
				promotionDto.setBrandId(resp.getBrandId().getBrandid());
				promotionDtos.add(promotionDto);
				
			}
			DataResultlist<PromotionDto> result=new DataResultlist<PromotionDto>(true, " available Promotions are ,", HttpStatus.OK.value(), promotionDtos);
			return new ResponseEntity(result, HttpStatus.OK);			
		}else
		{
			DataResult result=new DataResult(false, "Sorry , No Promotions are available right now ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
		}
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}
		return responseEntity;
	}	
	/*======================================================================================================*/
	
	
/*======================================================================================================*/
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/promotionsummary", method = RequestMethod.GET)
	public ResponseEntity PromotionSummary() {	
		final String METHOD_NAME="PromotionSummary";
		ResponseEntity responseEntity = null;
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = DATE_FORMAT.format(date);
		
		List<Promotionsummary> promotions = promotionService.promotionSummary(formattedDate);		
		try{
		if (!promotions.isEmpty()) {
			
			DataResultlist<Promotionsummary> result=new DataResultlist<Promotionsummary>(true, " available Promotions Summary are ,", HttpStatus.OK.value(), promotions);
			return new ResponseEntity(result, HttpStatus.OK);			
		}else
		{
			DataResult result=new DataResult(false, "Sorry , No Promotions Summary are available right now ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
		}
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}
		return responseEntity;
	}
	
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/createpromotions", method = RequestMethod.POST)
	public ResponseEntity createPromotions(@RequestBody CreatePromotionVo createPromotionVo) {		
		final String METHOD_NAME="createPromotions";
		ResponseEntity responseEntity = null;		
		MerchantProfile merchantId=MerchantDao.validatePromotion(createPromotionVo);	
		Category categoryid=promotionsDao.getcategoryId(createPromotionVo);
		Brand brandid=promotionsDao.getBrandId(createPromotionVo);
		try{
		if (merchantId!=null && categoryid!=null && brandid!=null ) {			
			Promotion resp = promotionService.CreatePromotions(createPromotionVo);			
			if (resp!=null) {
				DataResult result=new DataResult(true, " Promotion Posted successfully ... ", HttpStatus.OK.value());	
				return new ResponseEntity(result, HttpStatus.OK);
			}else
			{
			DataResult result=new DataResult(false, "Sorry , Please check categoryId/brandId/merchantId ...   ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
			}				
		}else
			{
			DataResult result=new DataResult(false, "Sorry , Please check categoryId/brandId/merchantId ...   ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
			}
		}catch(Exception exception){
			logger.error(" Exception in "+METHOD_NAME+""+exception.getMessage());
			
		}		
		return responseEntity;
	}
	
	/*======================================================================================================*/	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/categorypromotions", method = RequestMethod.POST)
	public ResponseEntity getCategoryPromotion(@RequestBody CategorySelection categorySelection) {
		final String METHOD_NAME="getCategoryPromotion";
		ResponseEntity responseEntity = null;
		Date date=new Date();
		List<Promotion> promotions = promotionService.getCategoryPromotions(date, categorySelection);
		try{
		if (!promotions.isEmpty()) {
			DataResultlist<Promotion> data=new DataResultlist<Promotion>(true, " Promotions are ,",HttpStatus.OK.value() , promotions);
			return new ResponseEntity(data, HttpStatus.OK);			
		}else{			
			DataResult result=new DataResult(false, " Sorry , No Promotions are available on selected category right now ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
		}		
		}
		catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}
		return responseEntity;
	}	
	/*===========================================================================================================*/
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/IdBasePromotions", method = RequestMethod.POST)
	public ResponseEntity getIdbasePromotions(@RequestBody IdBasePromotion idBasePromotion) {	
		final String METHOD_NAME="getIdbasePromotions";
		ResponseEntity responseEntity = null;
		Promotion promotions = promotionService.IdBasePromotions(idBasePromotion);
		try{
		if (promotions!=null) {			
			return new ResponseEntity(promotions, HttpStatus.OK);			
		}else
		{
			DataResult result=new DataResult(false, "Sorry , No Promotions are available on selected id ... ", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
		}
		}catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}
		return responseEntity;
	}
	
	/*===========================================================================================================*/		
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.LIST_COUNTRIES, method = RequestMethod.GET)
	public ResponseEntity fetchCountriesList(){
		final String METHOD_NAME="fetchCountriesList";
		List<Country> countries=locationService.fetchCountriesList();
		DataResultlist<CountryVO> result;
		DataResult resultError;
		ResponseEntity responseEntity = null;
		List<CountryVO> countryVOs=new ArrayList<CountryVO>();
		CountryVO countryVO;
		try{
			
		if (!countries.isEmpty()) {
			
			for(Country country:countries){
				countryVO=new CountryVO();
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis(country.getCreated().getTime() );
				Date date = calendar.getTime();
				SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
				String formattedDate = DATE_FORMAT.format(date);
				countryVO.setCountryId(country.getId().toString());
				countryVO.setCountryName(country.getName());
				countryVO.setCreatedDate(formattedDate);
				countryVOs.add(countryVO);
			}
			result=new DataResultlist<CountryVO>(true, AppConstants.LIST_COUNTRIES_SUCCESS_MSG, HttpStatus.OK.value(), countryVOs);
			responseEntity= new ResponseEntity(result, HttpStatus.OK);			
		}else
		{
			resultError=new DataResult(false, AppConstants.LIST_COUNTRIES_ERROR_MSG, HttpStatus.BAD_REQUEST.value());
			responseEntity= new ResponseEntity(resultError, HttpStatus.BAD_REQUEST);
		}
		
		}
		catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}
		return responseEntity;
		
	}
	
	/*===========================================================================================================*/	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.LIST_CITIES, method = RequestMethod.GET)
	public ResponseEntity fetchCitiesList(){
		final String METHOD_NAME="fetchCitiesList";
		List<Cities> cities=locationService.fetchCitiesList();
		DataResultlist<CitiesVO> result;
		DataResult resultError;
		ResponseEntity responseEntity = null;
		List<CitiesVO> citiesVOs=new ArrayList<CitiesVO>();
		CitiesVO citiesVO;
		try {
		if (!cities.isEmpty()) {			
			for(Cities citiesLocal:cities){
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis( citiesLocal.getCreated().getTime() );
				Date date = calendar.getTime();
				SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
		        String formattedDate = DATE_FORMAT.format(date);
				citiesVO=new CitiesVO();
				citiesVO.setCityId(citiesLocal.getCityId().toString());
				citiesVO.setCityName(citiesLocal.getCityName());
				citiesVO.setCountryId(citiesLocal.getCountryId().getId().toString());
				citiesVO.setCreatedDate(formattedDate);
				citiesVOs.add(citiesVO);				
			}
			result=new DataResultlist<CitiesVO>(true, AppConstants.LIST_CITIES_SUCCESS_MSG, HttpStatus.OK.value(), citiesVOs);
			responseEntity=new ResponseEntity(result, HttpStatus.OK);			
		}else
		{
			resultError=new DataResult(false, AppConstants.LIST_CITIES_ERROR_MSG, HttpStatus.BAD_REQUEST.value());
			responseEntity= new ResponseEntity(resultError, HttpStatus.BAD_REQUEST);
		}
		}
		catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}
		return responseEntity;
		
	}
	
	/*===========================================================================================================*/	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.LIST_LOCATIONS, method = RequestMethod.GET)
	public ResponseEntity fetchLocationsList(){
		final String METHOD_NAME="fetchLocationsList";
		List<Location> locations=locationService.fetchLocationsList();
		DataResultlist<LocationsVO> result = null;
		DataResult resultError;
		ResponseEntity responseEntity = null;
		List<LocationsVO> locationsVOs=new ArrayList<LocationsVO>();
		LocationsVO locationsVO;		
		try {
		if (!locations.isEmpty()) {			
			for(Location location:locations){
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis( location.getCreated().getTime() );
				Date date = calendar.getTime();
				SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
		        String formattedDate = DATE_FORMAT.format(date);
				locationsVO=new LocationsVO();
				locationsVO.setCityId(location.getCitiesId().getCityId().toString());
				locationsVO.setCountryId(location.getCountryId().getId().toString());
				locationsVO.setCreatedDate(formattedDate);
				locationsVO.setLattitude(location.getLocationLatitude());
				locationsVO.setLongitude(location.getLocationLongitude());
				locationsVO.setLocationId(location.getLocationId().toString());
				locationsVO.setLocationName(location.getLocationName());
				locationsVOs.add(locationsVO);				
			}			
			 result=new DataResultlist<LocationsVO>(true, AppConstants.LIST_LOCATIONS_SUCCESS_MSG, HttpStatus.OK.value(), locationsVOs);
			 responseEntity=new ResponseEntity(result, HttpStatus.OK);			
		}else
		{
			resultError=new DataResult(false, AppConstants.LIST_LOCATIONS_ERROR_MSG, HttpStatus.BAD_REQUEST.value());
			responseEntity=new ResponseEntity(resultError, HttpStatus.BAD_REQUEST);
			
		}	 
		}
		catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}
		return responseEntity;
	}
	/*===========================================================================================================*/
	
	
	/*===========================================================================================================*/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.LIST_CATEGORIES, method = RequestMethod.GET)
	public ResponseEntity fetchCategoriesList(){
		final String METHOD_NAME="fetchCategoriesList";
		List<Category> categories=metaDataService.fetchCategories();
		List<CategoryVO> categoryVOs=new ArrayList<CategoryVO>();
		ResponseEntity responseEntity = null;
		DataResult resultError;
		DataResultlist<CategoryVO> result;
		CategoryVO categoryVO;
		
		
		try{
			if(!categories.isEmpty()){
				
				for(Category category:categories){
					Calendar calendar = Calendar.getInstance();
					calendar.setTimeInMillis( category.getCreateddate().getTime() );
					Date date = calendar.getTime();
					SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
			        String formattedDate = DATE_FORMAT.format(date);
					categoryVO=new CategoryVO();
					categoryVO.setCategoryId(category.getCategoryId().toString());
					categoryVO.setCategoryName(category.getCategoryName());
					categoryVO.setCreatedDate(formattedDate);
					categoryVO.setCategoryRank(category.getCategoryRank());
					categoryVO.setCategoryImage(category.getCategoryImage());
					categoryVOs.add(categoryVO);
				}
				result=new DataResultlist<CategoryVO>(true, AppConstants.LIST_CATEGORIES_SUCCESS_MSG, HttpStatus.OK.value(), categoryVOs);
				responseEntity=new ResponseEntity(result, HttpStatus.OK);	
			} else{
				
				resultError=new DataResult(false, AppConstants.LIST_CATEGORIES_ERROR_MSG, HttpStatus.BAD_REQUEST.value());
				responseEntity=new ResponseEntity(resultError,HttpStatus.BAD_REQUEST);
			}
		}
		catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}
		return responseEntity;
		
	}
	
	/*===========================================================================================================*/
	
	/*===========================================================================================================*/
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.LIST_BRANDS, method = RequestMethod.GET)
	public ResponseEntity fetchBrandsList() {
		final String METHOD_NAME="fetchBrandsList";
		List<CategoryBrandVO> categories= metaDataService.fetchBrands();
		ResponseEntity<CategoryBrandVO>  responseEntity = null;
		DataResultlist<CategoryBrandVO> result;
		DataResult resultError;
		try{
			
			if (!categories.isEmpty()) {		
				result=new DataResultlist<CategoryBrandVO>(true, AppConstants.LIST_BRANDS_SUCCESS_MSG,HttpStatus.OK.value(), categories);	
				return new ResponseEntity(result , HttpStatus.OK);			
				}
			else{
				resultError=new DataResult(false, AppConstants.LIST_BRANDS_ERROR_MSG, HttpStatus.BAD_REQUEST.value());
				return new ResponseEntity(resultError, HttpStatus.BAD_REQUEST);
				}
			
		}
		catch(Exception exception){
			logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
		}
		return responseEntity;
		
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.LIST_MERCHANT_PRODUCTS, method = RequestMethod.POST)
	public ResponseEntity fetchMerchatProducts(@RequestBody ProductVO productVO) {
		final String METHOD_NAME="fetchMerchatProducts";
		List<ProductVO> productVOs = metaDataService.fetchMerchantProducts(productVO);
		ResponseEntity<ProductVO> responseEntity=null;
		DataResultlist<ProductVO> result;
		DataResult resultError;
		try{
			
			if (!productVOs.isEmpty()) {	
				result=new DataResultlist<ProductVO>(true, AppConstants.LIST_MERCHANT_PRODUCTS_SUCCESS_MSG,HttpStatus.OK.value(), productVOs);	
				return new ResponseEntity(result , HttpStatus.OK);			
			}
			else {
				resultError=new DataResult(false, AppConstants.LIST_MERCHANT_PRODUCTS_ERROR_MSG, HttpStatus.BAD_REQUEST.value());
				return new ResponseEntity(resultError, HttpStatus.BAD_REQUEST);
			}
	   }
			catch(Exception exception){
				logger.error("Exception in "+METHOD_NAME+""+exception.getMessage());
			}
			return responseEntity;
	  }
		
		
	
	
	
	
	/*===========================================================================================================*/
	
}
