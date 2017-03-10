package com.omniwyse.dod.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.omniwyse.dod.AppConstants.AppConstants;
import com.omniwyse.dod.DTO.BeaconInformationVO;
import com.omniwyse.dod.DTO.BrandVO;
import com.omniwyse.dod.DTO.CategoryBrandVO;
import com.omniwyse.dod.DTO.CategoryPromotion;
import com.omniwyse.dod.DTO.CategoryVO;
import com.omniwyse.dod.DTO.CitiesVO;
import com.omniwyse.dod.DTO.CountryVO;
import com.omniwyse.dod.DTO.CreatePromotionVo;
import com.omniwyse.dod.DTO.LocationVO;
import com.omniwyse.dod.DTO.LocationsVO;
import com.omniwyse.dod.DTO.MPBSearchVO;
import com.omniwyse.dod.DTO.MerchantPromotionBeaconSearchVo;
import com.omniwyse.dod.DTO.MerchantPromotionBeaconVO;
import com.omniwyse.dod.DTO.MercnantDTO;
import com.omniwyse.dod.DTO.NewProductVO;
import com.omniwyse.dod.DTO.ProductVO;
import com.omniwyse.dod.DTO.PromotionDto;
import com.omniwyse.dod.bean.DataResult;
import com.omniwyse.dod.bean.DataResultEntity;
import com.omniwyse.dod.bean.DataResultlist;
import com.omniwyse.dod.bean.OtpBean;
import com.omniwyse.dod.dao.MerchantDao;
import com.omniwyse.dod.dao.MetaDataDao;
import com.omniwyse.dod.dao.ProductDao;
import com.omniwyse.dod.dao.PromotionsDao;
import com.omniwyse.dod.dao.RegisterationValidateDao;
import com.omniwyse.dod.model.Beacon;
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
import com.omniwyse.dod.model.MerchantAisle;
import com.omniwyse.dod.model.MerchantLogin;
import com.omniwyse.dod.model.MerchantLoginwithEmail;
import com.omniwyse.dod.model.MerchantLoginwithMobile;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.MerchantPromotionBeacon;
import com.omniwyse.dod.model.MerchantPromotions;
import com.omniwyse.dod.model.OTPValidation;
import com.omniwyse.dod.model.Product;
import com.omniwyse.dod.model.Promotion;
import com.omniwyse.dod.model.Promotionsummary;
import com.omniwyse.dod.model.RegisterWithOtp;
import com.omniwyse.dod.service.ConsumerService;
import com.omniwyse.dod.service.LocationService;
import com.omniwyse.dod.service.MerchantPromotionBeaconService;
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
	RegisterationValidateDao consumerRegisterValidate;
	@Autowired
	ValidationService validationService;
	@Autowired
	PromotionService promotionService;
	@Autowired
	MerchantService merchantService;
	@Autowired
	MerchantDao merchantDao;
	@Autowired
	LocationService locationService;
	@Autowired
	MetaDataService metaDataService;
	@Autowired
	PromotionsDao promotionsDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	MerchantPromotionBeaconService merchantPromotionBeaconService;
	@Autowired
	MetaDataDao metaDataDao;

	private static final Logger logger = Logger.getLogger(DODController.class);

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	@RequestMapping(value = AppConstants.REGISTER, method = RequestMethod.POST)
	public ResponseEntity savewithOTP(@RequestBody RegisterWithOtp registerWithOtp) {
		final String METHOD_NAME = "savewithOTP";
		ResponseEntity responseEntity = null;	
		try {
			RegisterWithOtp data = consumerRegisterValidate.getmobileno(registerWithOtp);
			if (data == null) {				 
				Random random=new Random();
				int number=random.nextInt(9999999);						
				registerWithOtp.setOtpno(String.valueOf(number));				
				OtpBean otpBean = new OtpBean("OTP For Registration !!", number);
				RegisterWithOtp model = registrationService.register(registerWithOtp);
				return new ResponseEntity(otpBean, HttpStatus.OK);
			} else {
				DataResult dataResult = new DataResult(true, AppConstants.REGISTER_ERROR_MSG ,HttpStatus.OK.value());
				return new ResponseEntity(dataResult, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.OTP_VALIDATE, method = RequestMethod.POST)
	public ResponseEntity getOTP(@RequestBody OTPValidation oTPValidation) {
		final String METHOD_NAME = "getOTP";
		ResponseEntity responseEntity = null;
	
		try {
			RegisterWithOtp data = validationService.getotp(oTPValidation);
			if (data != null) {
				DataResult result = new DataResult(true, AppConstants.OTP_VALIDATE_SUCCESS_MSG, HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			} else {
				DataResult result = new DataResult(true, AppConstants.OTP_VALIDATE_ERROR_MSG,HttpStatus.OK.value());
				
				return new ResponseEntity(result, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	@RequestMapping(value = AppConstants.CONSUMER_REGISTER, method = RequestMethod.POST)
	public ResponseEntity registerConsumer(@RequestBody ConsumerProfile consumerProfile) {
		final String METHOD_NAME = "registerConsumer";
		ResponseEntity responseEntity = null;
		
		try {
			ConsumerProfile data = consumerRegisterValidate.getmobilenoandemail(consumerProfile);
			if (data == null) {
				ConsumerProfile model = consumerService.registerconsumer(consumerProfile);
				DataResult result = new DataResult(true, AppConstants.CONSUMER_REGISTER_SUCCESS_MSG,
						HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			} else {
				DataResult result = new DataResult(true, AppConstants.CONSUMER_REGISTER_ERROR_MSG,
						HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.CONSUMER_LOGIN, method = RequestMethod.POST)
	public ResponseEntity checkMobile(@RequestBody ConsumerLogin userLogin) {
		final String METHOD_NAME = "checkMobile";
		ResponseEntity responseEntity = null;		
		try {
			RegisterWithOtp resp = consumerService.consumerLogin(userLogin);
			if (resp != null) {
				DataResult result = new DataResult(true, AppConstants.CONSUMER_LOGIN_SUCCESS_MSG, HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			} else {
				DataResult result = new DataResult(true, AppConstants.CONSUMER_LOGIN_ERROR_MSG,
						HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.CONSUMER_PROFILE, method = RequestMethod.POST)
	public ResponseEntity consumerProfile(@RequestBody ConsumerIdBaseProfile consumerIdBaseProfile) {
		final String METHOD_NAME = "consumerProfile";
		ResponseEntity responseEntity = null;
		
		try {
			ConsumerProfile resp = consumerService.consumerProfile(consumerIdBaseProfile);
			if (resp != null) {
				DataResultEntity<ConsumerProfile> data = new DataResultEntity<ConsumerProfile>(true,
						AppConstants.CONSUMER_PROFILE_SUCCESS_MSG, HttpStatus.OK.value(), resp);
				return new ResponseEntity(data, HttpStatus.OK);
			} else {
				DataResult result = new DataResult(true, AppConstants.CONSUMER_PROFILE_ERROR_MSG , HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.CONSUMER_EMAIL_LOGIN, method = RequestMethod.POST)
	public ResponseEntity checkEmailAndPassword(@RequestBody ConsumerLoginwithEmail userLogin) {
		final String METHOD_NAME = "checkEmailAndPassword";
		ResponseEntity responseEntity = null;
		
		try {
			ConsumerProfile resp = consumerService.consumerautheticatewithemail(userLogin);
			if (resp != null) {
				DataResult result = new DataResult(true, AppConstants.CONSUMER_LOGIN_SUCCESS_MSG, HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			} else {
				DataResult result = new DataResult(true, AppConstants.CONSUMER_LOGIN_ERROR_MSG,
						HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.CONSUMER_MOBILE_LOGIN, method = RequestMethod.POST)
	public ResponseEntity checkMobilenoAndPassword(@RequestBody ConsumerLoginwithMobile userLogin) {
		final String METHOD_NAME = "checkMobilenoAndPassword";
		ResponseEntity responseEntity = null;
		
		try {
			ConsumerProfile resp = consumerService.consumerautheticatewithMobile(userLogin);
			if (resp != null) {
				DataResult result = new DataResult(true, AppConstants.CONSUMER_LOGIN_SUCCESS_MSG, HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			} else {
				DataResult result = new DataResult(true, AppConstants.CONSUMER_LOGIN_ERROR_MSG,
						HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.MERCHANT_REGISTER, method = RequestMethod.POST)
	public ResponseEntity registerMerchant(@RequestBody MerchantProfile merchantProfile) {
		final String METHOD_NAME = "registerMerchant";
		ResponseEntity responseEntity = null;
		
		try {
			MerchantProfile data = consumerRegisterValidate.getmobilenoandemail(merchantProfile);
			if (data == null) {
				MerchantProfile model = merchantService.registermerchant(merchantProfile);
				DataResultEntity<MerchantProfile> dataResult = new DataResultEntity<MerchantProfile>(true,
						AppConstants.MERCHANT_REGISTER_SUCCESS_MSG, HttpStatus.OK.value(), model);
				return new ResponseEntity(dataResult, HttpStatus.OK);
			} else {
				DataResult result = new DataResult(true, AppConstants.MERCHANT_REGISTER_ERROR_MSG,HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.MERCHANT_PROFILE, method = RequestMethod.POST)
	public ResponseEntity merchatProfile(@RequestBody GetMerchatProfile GetMerchatProfile) {
		final String METHOD_NAME = "merchatProfile";
		ResponseEntity responseEntity = null;
		
		try {
			MerchantProfile data = merchantService.merchatProfile(GetMerchatProfile);
			if (data != null) {
				
				MerchantProfile model = merchantService.merchatProfile(GetMerchatProfile);
				DataResultEntity<MerchantProfile> dataResult = new DataResultEntity<MerchantProfile>(true,AppConstants.MERCHANT_PROFILE_SUCCESS_MSG, HttpStatus.OK.value(), model);
				return new ResponseEntity(dataResult, HttpStatus.OK);
			} else {
				DataResult result = new DataResult(true, AppConstants.MERCHANT_PROFILE_ERROR_MSG,
						HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.MERCHANT_LIST, method = RequestMethod.GET)
	public ResponseEntity allMerchants() {
		final String METHOD_NAME = "allMerchants";
		ResponseEntity responseEntity = null;		
		List<MercnantDTO> response = new ArrayList<MercnantDTO>();
		MercnantDTO mercnantDTO;
		try {
			List<MerchantProfile> data = merchantService.allMerchants();
			if (!data.isEmpty()) {
				for (MerchantProfile response1 : data) {
					mercnantDTO = new MercnantDTO();
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
				DataResultlist<MercnantDTO> resp = new DataResultlist<MercnantDTO>(true, AppConstants.MERCHANT_LIST_SUCCESS_MSG,
						HttpStatus.OK.value(), response);
				return new ResponseEntity(resp, HttpStatus.OK);
			} else {
				DataResult result = new DataResult(true, AppConstants.MERCHANT_LIST_ERROR_MSG,
						HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/getmerchatbyMobile", method = RequestMethod.POST)
	public ResponseEntity getMerchatById(@RequestBody GetMerchantById getMerchantById) {
		final String METHOD_NAME = "getMerchatById";
		ResponseEntity responseEntity = null;
		
		try {
			MerchantProfile data = merchantService.getmerchantMobile(getMerchantById);
			if (data != null) {
				DataResultEntity<MerchantProfile> merchantProfile = new DataResultEntity<MerchantProfile>(true,
						" Succes ,  Merchant Details is  ", HttpStatus.OK.value(), data);

				return new ResponseEntity(merchantProfile, HttpStatus.OK);
			} else {
				DataResult result = new DataResult(true, "Sorry , No details found on selected id ... ",
						HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.MERCHANT_PROMOTION_MERCHANTID, method = RequestMethod.POST)
	public ResponseEntity merchantPromotions(@RequestBody MerchantPromotions MerchantPromotions) {
		final String METHOD_NAME = "merchantPromotions";
		ResponseEntity responseEntity = null;
		Date date = new Date();		
		List<PromotionDto> promotionDtos = new ArrayList<PromotionDto>();
		PromotionDto promotionDto;
		try {
			List<Promotion> data = merchantService.merchatPromotion(MerchantPromotions, date);
			if (!data.isEmpty()) {
				for (Promotion response : data) {
						promotionDto = new PromotionDto();
						promotionDto.setId(response.getId());					
						promotionDto.setProduct_id(String.valueOf(response.getProductID().getProductId()));
						promotionDto.setId(response.getId());
						promotionDto.setProduct_image(response.getProductID().getProductImageLocation());
						promotionDto.setOriginalPrice(response.getOriginalPrice());
						promotionDto.setDiscount(response.getDiscount());
						promotionDto.setStartdate(response.getStartdate());
						promotionDto.setEnddate(response.getEnddate());
						promotionDto.setLocationId(String.valueOf(response.getLocationId().getLocationId()));
						promotionDto.setLocationName(response.getLocationId().getLocationName());
						promotionDto.setMerchatId(response.getMerchatId().getId());
						promotionDto.setDiscountText(response.getDiscountText());
						promotionDto.setCatid(response.getCatid().getCategoryId());
						promotionDto.setCategoryName(response.getCatid().getCategoryName());
						promotionDto.setBrandId(response.getBrandId().getBrandid());
						promotionDto.setBrandName(response.getBrandId().getBrandName());
						promotionDto.setBrandImage(response.getBrandId().getBrandImage());
						promotionDto.setBrandRating(response.getBrandId().getBrandRating());
						promotionDto.setBrandDescription(response.getBrandId().getBrandDescription());				
						promotionDto.setDescription(response.getDescription());
						promotionDto.setCreateddate(response.getCreateddate());
						promotionDto.setBrandDescription(response.getBrandId().getBrandDescription());
						promotionDtos.add(promotionDto);
				}
				DataResultlist<PromotionDto> resp = new DataResultlist<PromotionDto>(true, AppConstants.MERCHANT_PROMOTION_SUCCESS_MSG,
						HttpStatus.OK.value(), promotionDtos);
				return new ResponseEntity(resp, HttpStatus.OK);
			} else {
				DataResult result = new DataResult(true, AppConstants.MERCHANT_PROMOTION_ERROR_MSG,
						HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.MERCHANT_LOGIN, method = RequestMethod.POST)
	public ResponseEntity checkMerchatUsernameAndPassword(@RequestBody MerchantLogin merchantLogin) {
		final String METHOD_NAME = "checkMerchatUsernameAndPassword";
		ResponseEntity responseEntity = null;		
		try {
			MerchantProfile resp = merchantService.merchatLogin(merchantLogin);
			if (resp != null) {
				MerchantProfile merchantProfile = merchantDao.getMerchant(merchantLogin);
				MercnantDTO merchnantDTO = new MercnantDTO();
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
				DataResultEntity<MercnantDTO> result = new DataResultEntity<MercnantDTO>(true,
						AppConstants.MERCHANT_LOGIN_SUCCESS_MSG, HttpStatus.OK.value(), merchnantDTO);
				return new ResponseEntity(result, HttpStatus.OK);
			} else {
				DataResult result = new DataResult(true, AppConstants.MERCHANT_LOGIN_ERROR_MSG,
						HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.MERCHANT_EMAIL_LOGIN, method = RequestMethod.POST)
	public ResponseEntity checkEmailAndPassword(@RequestBody MerchantLoginwithEmail merchantLoginwithEmail) {
		final String METHOD_NAME = "checkEmailAndPassword";
		ResponseEntity responseEntity = null;		
		try {
			MerchantProfile resp = merchantService.merchatAutheticateWithEmail(merchantLoginwithEmail);
			if (resp != null) {
				DataResult result = new DataResult(true, AppConstants.MERCHANT_LOGIN_SUCCESS_MSG, HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			} else {
				DataResult result = new DataResult(true, AppConstants.MERCHANT_LOGIN_ERROR_MSG,
						HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.MERCHANT_MOBILE_LOGIN, method = RequestMethod.POST)
	public ResponseEntity checkMobileAndPassword(@RequestBody MerchantLoginwithMobile merchantLoginwithMobile) {
		final String METHOD_NAME = "checkMobileAndPassword";
		ResponseEntity responseEntity = null;		
		try {
			MerchantProfile resp = merchantService.merchatAutheticateWithMobile(merchantLoginwithMobile);
			if (resp != null) {
				DataResult result = new DataResult(true, AppConstants.MERCHANT_LOGIN_SUCCESS_MSG, HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			} else {
				DataResult result = new DataResult(true, AppConstants.MERCHANT_LOGIN_ERROR_MSG,
						HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;

	}	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.LIST_PROMOTIONS, method = RequestMethod.GET)
	public ResponseEntity getPromotions() {
		final String METHOD_NAME = "getPromotions";
		ResponseEntity responseEntity = null;
		
		List<PromotionDto> promotionDtos = new ArrayList<PromotionDto>();
		PromotionDto promotionDto;
		try {
			List<Promotion> promotions = promotionService.getPromotions();
			if (!promotions.isEmpty()) {
				for (Promotion resp : promotions) {
					promotionDto = new PromotionDto();
					promotionDto.setId(resp.getId());
					promotionDto.setProduct_id(String.valueOf(resp.getProductID().getProductId()));
					promotionDto.setProduct_image(resp.getProductID().getProductImageLocation());
					promotionDto.setDescription(resp.getDescription());
					promotionDto.setMerchatId(resp.getMerchatId().getId());
					promotionDto.setProduct_image(resp.getProductID().getProductImageLocation());
					promotionDto.setOriginalPrice(resp.getOriginalPrice());
					promotionDto.setDiscount(resp.getDiscount());
					promotionDto.setLocationId(String.valueOf(resp.getLocationId().getLocationId()));
					promotionDto.setLocationName(resp.getLocationId().getLocationName());
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
					promotionDto.setDiscountText(resp.getDiscountText());
					promotionDtos.add(promotionDto);
				}
				DataResultlist<PromotionDto> result = new DataResultlist<PromotionDto>(true,
						AppConstants.PROMOTION_SUCCESS_MSG, HttpStatus.OK.value(), promotionDtos);
				return new ResponseEntity(result, HttpStatus.OK);
			} else {
				DataResult result = new DataResult(true, AppConstants.PROMOTION_ERROR_MSG,
						HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.LIST_PROMOTIONS_CATEGORYID, method = RequestMethod.POST)
	public ResponseEntity categoryIdPromotion(@RequestBody CategoryPromotion categoryPromotion) {
		final String METHOD_NAME = "CategoryIdPromotion";
		ResponseEntity responseEntity = null;
		List<PromotionDto> promotions = promotionService.categoryIdPromotions(categoryPromotion);
		try {
			if (!promotions.isEmpty()) {

				DataResultlist<PromotionDto> dataResultlist = new DataResultlist<PromotionDto>(true,
						AppConstants.PROMOTION_SUCCESS_MSG, HttpStatus.OK.value(), promotions);
				return new ResponseEntity(dataResultlist, HttpStatus.OK);

			} else {
				DataResult result = new DataResult(true,
						AppConstants.PROMOTION_ERROR_MSG, 
						HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.LIST_BRANDID_PROMOTIONS, method = RequestMethod.POST)
	public ResponseEntity brandIdPromotion(@RequestBody CategoryPromotion categoryPromotion) {
		final String METHOD_NAME = "brandIdPromotion";
		ResponseEntity responseEntity = null;
		
		try {
			List<PromotionDto> promotions = promotionService.brandIdPromotions(categoryPromotion);
			if (!promotions.isEmpty()) {
				DataResultlist<PromotionDto> resp = new DataResultlist<PromotionDto>(true,
						AppConstants.AVAILABE_PROMOTIONS_SUCCESS_MSG, HttpStatus.OK.value(), promotions);
				return new ResponseEntity(resp, HttpStatus.OK);
			} else {
				DataResult result = new DataResult(true, AppConstants.AVAILABE_PROMOTIONS_ERROR_MSG,
						HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.LIST_BRANDID_CATEGORYID, method = RequestMethod.POST)
	public ResponseEntity brandCatIdPromotion(@RequestBody CategoryPromotion categoryPromotion) {
		final String METHOD_NAME = "brandCatIdPromotion";
		ResponseEntity responseEntity = null;
		
		try {
			List<PromotionDto> promotions = promotionService.brandCatIdPromotion(categoryPromotion);
			if (!promotions.isEmpty()) {
				DataResultlist<PromotionDto> resp = new DataResultlist<PromotionDto>(true,
						" available promotions are ... ", HttpStatus.OK.value(), promotions);
				return new ResponseEntity(resp, HttpStatus.OK);
			} else {
				DataResult result = new DataResult(true,
						"Sorry , No Promotions are available on selected Id right now ",
						HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.PROMOTION_SUMMERY, method = RequestMethod.GET)
	public ResponseEntity promotionSummary() {
		final String METHOD_NAME = "PromotionSummary";
		ResponseEntity responseEntity = null;
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = DATE_FORMAT.format(date);
		
		try {
			List<Promotionsummary> promotions = promotionService.promotionSummary(formattedDate);
			if (!promotions.isEmpty()) {

				DataResultlist<Promotionsummary> result = new DataResultlist<Promotionsummary>(true,
						AppConstants.AVAILABE_PROMOTIONS_SUCCESS_MSG, HttpStatus.OK.value(), promotions);
				return new ResponseEntity(result, HttpStatus.OK);
			} else {
				DataResult result = new DataResult(true, AppConstants.PROMOTION_ERROR_MSG,
						HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.CREATE_PROMOTIONS, method = RequestMethod.POST)
	public ResponseEntity createPromotions(@RequestBody CreatePromotionVo createPromotionVo) {
		final String METHOD_NAME = "createPromotions";
		ResponseEntity responseEntity = null;
		
		try {
			MerchantProfile merchantId = merchantDao.validatePromotion(createPromotionVo);
			Category categoryid = promotionsDao.getcategoryId(createPromotionVo);
			Brand brandid = promotionsDao.getBrandId(createPromotionVo);
			Product productId=promotionsDao.fetchProductById(createPromotionVo);
			if (merchantId != null && categoryid != null && brandid != null && productId!=null) {
				createPromotionVo.setProductId(productId);
				createPromotionVo.setMerchantProfile(merchantId);
				Promotion resp = promotionService.createPromotions(createPromotionVo);
				if (resp != null) {
					DataResult result = new DataResult(true, AppConstants.PROMOTIONS_SUCCESS_MSG,
							HttpStatus.OK.value());
					return new ResponseEntity(result, HttpStatus.OK);
				} else {
					DataResult result = new DataResult(true, AppConstants.PROMOTIONS_ERROR_MSG,
							HttpStatus.OK.value());
					return new ResponseEntity(result, HttpStatus.OK);
				}
			} else {
				DataResult result = new DataResult(true, AppConstants.PROMOTIONS_ERROR_MSG,
						HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error(" Exception in " + METHOD_NAME + "" + exception.getMessage());

		}
		return responseEntity;

	}	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/categorypromotions", method = RequestMethod.POST)
	public ResponseEntity getCategoryPromotion(@RequestBody CategorySelection categorySelection) {
		final String METHOD_NAME = "getCategoryPromotion";
		ResponseEntity responseEntity = null;
		Date date = new Date();
		
		try {
			List<Promotion> promotions = promotionService.getCategoryPromotions(date, categorySelection);
			if (!promotions.isEmpty()) {
				DataResultlist<Promotion> data = new DataResultlist<Promotion>(true, " available Promotions are ,",
						HttpStatus.OK.value(), promotions);
				return new ResponseEntity(data, HttpStatus.OK);
			} else {
				DataResult result = new DataResult(true,
						" Sorry , No Promotions are available on selected category right now ",
						HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.IDBASE_PROMOTIONS, method = RequestMethod.POST)
	public ResponseEntity getIdbasePromotions(@RequestBody IdBasePromotion idBasePromotion) {
		final String METHOD_NAME = "getIdbasePromotions";
		ResponseEntity responseEntity = null;
		
		try {
			Promotion promotions = promotionService.idBasePromotions(idBasePromotion);
			if (promotions != null) {			
				DataResultEntity<Promotion> result = new DataResultEntity<Promotion>(true, AppConstants.PROMOTION_SUCCESS_MSG,HttpStatus.OK.value(),promotions);				
				return new ResponseEntity(result, HttpStatus.OK);
			} else {
				DataResult result = new DataResult(true, AppConstants.PROMOTION_ERROR_MSG,HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.LIST_COUNTRIES, method = RequestMethod.GET)
	public ResponseEntity fetchCountriesList() {
		final String METHOD_NAME = "fetchCountriesList";
		
		DataResultlist<CountryVO> result;
		DataResult resultError;
		ResponseEntity responseEntity = null;
		List<CountryVO> countryVOs = new ArrayList<CountryVO>();
		CountryVO countryVO;
		try {
			List<Country> countries = locationService.fetchCountriesList();
			if (!countries.isEmpty()) {

				for (Country country : countries) {
					countryVO = new CountryVO();
					Calendar calendar = Calendar.getInstance();
					calendar.setTimeInMillis(country.getCreated().getTime());
					Date date = calendar.getTime();
					SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
					String formattedDate = DATE_FORMAT.format(date);
					countryVO.setCountryId(country.getId().toString());
					countryVO.setCountryName(country.getName());
					countryVO.setCreatedDate(formattedDate);
					countryVOs.add(countryVO);
				}
				result = new DataResultlist<CountryVO>(true, AppConstants.LIST_COUNTRIES_SUCCESS_MSG,
						HttpStatus.OK.value(), countryVOs);
				responseEntity = new ResponseEntity(result, HttpStatus.OK);
			} else {
				resultError = new DataResult(true, AppConstants.LIST_COUNTRIES_ERROR_MSG,
						HttpStatus.OK.value());
				responseEntity = new ResponseEntity(resultError, HttpStatus.OK);
			}

		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.LIST_CITIES, method = RequestMethod.GET)
	public ResponseEntity fetchCitiesList() {
		final String METHOD_NAME = "fetchCitiesList";
		
		DataResultlist<CitiesVO> result;
		DataResult resultError;
		ResponseEntity responseEntity = null;
		List<CitiesVO> citiesVOs = new ArrayList<CitiesVO>();
		CitiesVO citiesVO;
		try {
			List<Cities> cities = locationService.fetchCitiesList();
			if (!cities.isEmpty()) {
				for (Cities citiesLocal : cities) {
					Calendar calendar = Calendar.getInstance();
					calendar.setTimeInMillis(citiesLocal.getCreated().getTime());
					Date date = calendar.getTime();
					SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
					String formattedDate = DATE_FORMAT.format(date);
					citiesVO = new CitiesVO();
					citiesVO.setCityId(citiesLocal.getCityId().toString());
					citiesVO.setCityName(citiesLocal.getCityName());
					citiesVO.setCountryId(citiesLocal.getCountryId().getId().toString());
					citiesVO.setCreatedDate(formattedDate);
					citiesVOs.add(citiesVO);
				}
				result = new DataResultlist<CitiesVO>(true, AppConstants.LIST_CITIES_SUCCESS_MSG, HttpStatus.OK.value(),
						citiesVOs);
				responseEntity = new ResponseEntity(result, HttpStatus.OK);
			} else {
				resultError = new DataResult(true, AppConstants.LIST_CITIES_ERROR_MSG, HttpStatus.OK.value());
				responseEntity = new ResponseEntity(resultError, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.LIST_LOCATIONS, method = RequestMethod.GET)
	public ResponseEntity fetchLocationsList() {
		final String METHOD_NAME = "fetchLocationsList";
		
		DataResultlist<LocationsVO> result = null;
		DataResult resultError;
		ResponseEntity responseEntity = null;
		List<LocationsVO> locationsVOs = new ArrayList<LocationsVO>();
		LocationsVO locationsVO;
		try {
			List<Location> locations = locationService.fetchLocationsList();
			if (!locations.isEmpty()) {
				for (Location location : locations) {
					Calendar calendar = Calendar.getInstance();
					calendar.setTimeInMillis(location.getCreated().getTime());
					Date date = calendar.getTime();
					SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
					String formattedDate = DATE_FORMAT.format(date);
					locationsVO = new LocationsVO();
					locationsVO.setCityId(location.getCitiesId().getCityId().toString());
					locationsVO.setCountryId(location.getCountryId().getId().toString());
					locationsVO.setCreatedDate(formattedDate);
					locationsVO.setLattitude(location.getLocationLatitude());
					locationsVO.setLongitude(location.getLocationLongitude());
					locationsVO.setLocationId(location.getLocationId().toString());
					locationsVO.setLocationName(location.getLocationName());
					locationsVOs.add(locationsVO);
				}
				result = new DataResultlist<LocationsVO>(true, AppConstants.LIST_LOCATIONS_SUCCESS_MSG,
						HttpStatus.OK.value(), locationsVOs);
				responseEntity = new ResponseEntity(result, HttpStatus.OK);
			} else {
				resultError = new DataResult(true, AppConstants.LIST_LOCATIONS_ERROR_MSG,
						HttpStatus.OK.value());
				responseEntity = new ResponseEntity(resultError, HttpStatus.OK);

			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.LIST_CATEGORIES, method = RequestMethod.GET)
	public ResponseEntity fetchCategoriesList() {
		final String METHOD_NAME = "fetchCategoriesList";
		
		List<CategoryVO> categoryVOs = new ArrayList<CategoryVO>();
		ResponseEntity responseEntity = null;
		DataResult resultError;
		DataResultlist<CategoryVO> result;
		CategoryVO categoryVO;
		try {
			List<Category> categories = metaDataService.fetchCategories();
			if (!categories.isEmpty()) {

				for (Category category : categories) {
					Calendar calendar = Calendar.getInstance();
					calendar.setTimeInMillis(category.getCreateddate().getTime());
					Date date = calendar.getTime();
					SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
					String formattedDate = DATE_FORMAT.format(date);
					categoryVO = new CategoryVO();
					categoryVO.setCategoryId(category.getCategoryId().toString());
					categoryVO.setCategoryName(category.getCategoryName());
					categoryVO.setCreatedDate(formattedDate);
					categoryVO.setCategoryRank(category.getCategoryRank());
					categoryVO.setCategoryImage(category.getCategoryImage());
					categoryVOs.add(categoryVO);
				}
				result = new DataResultlist<CategoryVO>(true, AppConstants.LIST_CATEGORIES_SUCCESS_MSG,
						HttpStatus.OK.value(), categoryVOs);
				responseEntity = new ResponseEntity(result, HttpStatus.OK);
			} else {

				resultError = new DataResult(true, AppConstants.LIST_CATEGORIES_ERROR_MSG,
						HttpStatus.OK.value());
				responseEntity = new ResponseEntity(resultError, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity; 
	}
	
	
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.CREATE_BRANDS, method = RequestMethod.POST)
	public ResponseEntity createBrands(@RequestBody BrandVO brandVO) {
		final String METHOD_NAME = "createBrands";		
		ResponseEntity responseEntity = null;
		DataResultEntity<Brand> result;
		DataResult resultError;
		try {
			Brand brandname=metaDataDao.getBrandname(brandVO);	
			if (brandname==null) {
				Brand brandVOs = metaDataService.createBrand(brandVO);
				result = new DataResultEntity<Brand>(true, AppConstants.CREATE_BRAND_SUCCESS_MSG,
						HttpStatus.OK.value(),brandVOs);				
				return new ResponseEntity(result, HttpStatus.OK);
			} else {
				resultError = new DataResult(true, AppConstants.CREATE_BRAND_ERROR_MSG , HttpStatus.OK.value());
				return new ResponseEntity(resultError, HttpStatus.OK);
			}

		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.LIST_All_BRANDS, method = RequestMethod.GET)
	public ResponseEntity BrandsList() {
		final String METHOD_NAME = "BrandsList";		
		ResponseEntity<BrandVO> responseEntity = null;
		DataResultlist<BrandVO> result;
		DataResult resultError;
		try {
			List<BrandVO> brandVOs = metaDataService.listBrands();

			if (!brandVOs.isEmpty()) {
				result = new DataResultlist<BrandVO>(true, AppConstants.LIST_ALL_BRANDS_SUCCESS_MSG,
						HttpStatus.OK.value(), brandVOs);
				return new ResponseEntity(result, HttpStatus.OK);
			} else {
				resultError = new DataResult(true, AppConstants.LIST_ALL_BRANDS_ERROR_MSG , HttpStatus.OK.value());
				return new ResponseEntity(resultError, HttpStatus.OK);
			}

		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.LIST_BRANDS, method = RequestMethod.GET)
	public ResponseEntity fetchBrandsList() {
		final String METHOD_NAME = "fetchBrandsList";
		
		ResponseEntity<CategoryBrandVO> responseEntity = null;
		DataResultlist<CategoryBrandVO> result;
		DataResult resultError;
		try {
			List<CategoryBrandVO> categories = metaDataService.fetchBrands();

			if (!categories.isEmpty()) {
				result = new DataResultlist<CategoryBrandVO>(true, AppConstants.LIST_BRANDS_SUCCESS_MSG,
						HttpStatus.OK.value(), categories);
				return new ResponseEntity(result, HttpStatus.OK);
			} else {
				resultError = new DataResult(true, AppConstants.LIST_BRANDS_ERROR_MSG, HttpStatus.OK.value());
				return new ResponseEntity(resultError, HttpStatus.OK);
			}

		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.LIST_MERCHANT_PRODUCTS, method = RequestMethod.POST)
	public ResponseEntity fetchMerchatProducts(@RequestBody ProductVO productVO) {
		final String METHOD_NAME = "fetchMerchatProducts";
		
		ResponseEntity<ProductVO> responseEntity = null;
		DataResultlist<ProductVO> result;
		DataResult resultError;
		try {
			List<ProductVO> productVOs = metaDataService.fetchMerchantProducts(productVO);
			if (!productVOs.isEmpty()) {
				result = new DataResultlist<ProductVO>(true, AppConstants.LIST_MERCHANT_PRODUCTS_SUCCESS_MSG,
						HttpStatus.OK.value(), productVOs);
				return new ResponseEntity(result, HttpStatus.OK);
			} else {
				resultError = new DataResult(true, AppConstants.LIST_MERCHANT_PRODUCTS_ERROR_MSG,
						HttpStatus.OK.value());
				return new ResponseEntity(resultError, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.CREATE_PRODUCTS, method = RequestMethod.POST)
	public ResponseEntity createMerchatProducts(@RequestBody NewProductVO newProductVO) {
		final String METHOD_NAME = "createMerchatProducts";
		ResponseEntity responseEntity = null;
		
		try {
			MerchantProfile merchantId = productDao.validateProduct(newProductVO);
			Product products = productDao.validateProductname(newProductVO);
			if (merchantId != null && products==null) {
				Product resp = metaDataService.createProduct(newProductVO, merchantId);
				if (resp != null) {
					DataResult result = new DataResult(true, " Product Created successfully ... ",
							HttpStatus.OK.value());
					return new ResponseEntity(result, HttpStatus.OK);
				} else {
					DataResult result = new DataResult(true, "Sorry , Please check merchantId/productId   ",
							HttpStatus.OK.value());
					return new ResponseEntity(result, HttpStatus.OK);
				}
			} else {
				DataResult result = new DataResult(true, "Sorry , Please check merchantId/productId    ",
						HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.CREATE_LOCATION, method = RequestMethod.POST)
	public ResponseEntity createLocation(@RequestBody LocationVO locationVO) {
		final String METHOD_NAME = "createLocation";
		ResponseEntity responseEntity = null;
		
		try {
			Location location = metaDataService.createLocation(locationVO);
			if (location != null) {
				DataResult result = new DataResult(true, " Location Created successfully ... ", HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			} else {
				DataResult result = new DataResult(true, "Sorry , Please enter valied details ... ",
						HttpStatus.OK.value());
				return new ResponseEntity(result, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.CREATE_MERCHANT_PROMOTION_BEACON, method = RequestMethod.POST)
	public ResponseEntity createMerchantPromotionBeacon(
			@RequestBody MerchantPromotionBeaconVO merchantPromotionBeaconVO) {
		final String METHOD_NAME = "createMerchantPromotionBeacon";
		ResponseEntity responseEntity = null;
		DataResult resultError;
		try {

			List dependentObjects = metaDataService.validateMPBCreation(merchantPromotionBeaconVO);
			if (!dependentObjects.isEmpty() && dependentObjects.size() == 4) {
				MerchantPromotionBeacon merchantPromotionBeacon = metaDataService
						.createMerchantPromotionBeacon(dependentObjects);
				if (merchantPromotionBeacon != null) {
					DataResultEntity<MerchantPromotionBeacon> result = new DataResultEntity<MerchantPromotionBeacon>(
							true, " Merchant Promotion Beacon Created successfully ... ", HttpStatus.OK.value(),
							merchantPromotionBeacon);
					return new ResponseEntity(result, HttpStatus.OK);
				} else {
					DataResult result = new DataResult(true,
							"Sorry , Please check merchantId/promotionId/beaconId/aisleId    ",
							HttpStatus.OK.value());
					return new ResponseEntity(result, HttpStatus.OK);
				}
			} else {
				resultError = new DataResult(true, "Sorry , Please check merchantId/promotionId/beaconId/aisleId    ",
						HttpStatus.OK.value());
				return new ResponseEntity(resultError, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.LIST_BEACONS_PROMOTIONS_INFO, method = RequestMethod.GET)
	public ResponseEntity getbeacons() {
		final String METHOD_NAME = "getbeacons";
		ResponseEntity responseEntity = null;
		MerchantPromotionBeaconSearchVo merchantPromotionBeaconSearchVo = null;
		MerchantProfile merchantProfileId;
		Promotion promotionId;
		Beacon beaconId;
		MerchantAisle merchantAisle;
		Cities cities;
		Country country;
		List<MerchantPromotionBeaconSearchVo> beaconSearchVos = new ArrayList<MerchantPromotionBeaconSearchVo>();
		DataResultlist<MerchantPromotionBeaconSearchVo> result;
		DataResult resultError;
		try {
			List<Object[]> resp = merchantPromotionBeaconService.getbeacons();
			if (!resp.isEmpty()) {
				for (Object[] response : resp) {
					merchantPromotionBeaconSearchVo = new MerchantPromotionBeaconSearchVo();
					merchantPromotionBeaconSearchVo.setMerchantId((Integer) response[0]);
					merchantPromotionBeaconSearchVo.setAisleId(String.valueOf(response[1]));
					merchantPromotionBeaconSearchVo.setBeaconId(String.valueOf(response[2]));
					merchantPromotionBeaconSearchVo.setPromotionId((Integer) response[3]);
					List<Object> dependentObjects = metaDataDao.fetchMPBObjects(merchantPromotionBeaconSearchVo);
					if (dependentObjects.size() > 0) {
						merchantProfileId = (MerchantProfile) dependentObjects.get(0);
						merchantPromotionBeaconSearchVo.setMerchantemailid(merchantProfileId.getEmailid());
						merchantPromotionBeaconSearchVo.setMerchantfirstname(merchantProfileId.getFirstname());
						merchantPromotionBeaconSearchVo.setMerchantId(merchantProfileId.getId());
						merchantPromotionBeaconSearchVo.setMerchantlastname(merchantProfileId.getLastname());
						merchantPromotionBeaconSearchVo.setMobilenumber(merchantProfileId.getMobilenumber());
						merchantPromotionBeaconSearchVo.setStreet(merchantProfileId.getStreet());
						merchantPromotionBeaconSearchVo.setState(merchantProfileId.getState());
						merchantPromotionBeaconSearchVo.setCountry(merchantProfileId.getCountry());
						merchantPromotionBeaconSearchVo.setZipcode(merchantProfileId.getZipcode());
						merchantPromotionBeaconSearchVo.setNickname(merchantProfileId.getNickname());
						merchantPromotionBeaconSearchVo.setTown(merchantProfileId.getTown());
						merchantPromotionBeaconSearchVo.setTags(merchantProfileId.getTags());
						merchantPromotionBeaconSearchVo.setLandlineno(merchantProfileId.getLandlineno());
						merchantPromotionBeaconSearchVo.setBusinessname(merchantProfileId.getBusinessname());
						merchantPromotionBeaconSearchVo.setBusinessoffaddr(merchantProfileId.getBusinessoffaddr());
						merchantPromotionBeaconSearchVo.setDescription(merchantProfileId.getDescription());
						merchantPromotionBeaconSearchVo.setCreated(merchantProfileId.getCreateddate());
					}
					if (dependentObjects.size() >= 1) {
						promotionId = (Promotion) dependentObjects.get(1);
						merchantPromotionBeaconSearchVo.setPromotionId(promotionId.getId());
						merchantPromotionBeaconSearchVo.setStartdate(promotionId.getStartdate());
						merchantPromotionBeaconSearchVo.setEnddate(promotionId.getEnddate());
						merchantPromotionBeaconSearchVo.setCreateddate(promotionId.getCreateddate());
						merchantPromotionBeaconSearchVo.setOriginalPrice(promotionId.getOriginalPrice());
						merchantPromotionBeaconSearchVo.setDiscount(promotionId.getDiscount());
						merchantPromotionBeaconSearchVo.setDiscountText(promotionId.getDiscountText());
						merchantPromotionBeaconSearchVo.setLocationId(String.valueOf(promotionId.getLocationId().getLocationId()));
						merchantPromotionBeaconSearchVo.setLocationName(promotionId.getLocationId().getLocationName());
						merchantPromotionBeaconSearchVo.setMerchantId(promotionId.getMerchatId().getId());
						merchantPromotionBeaconSearchVo.setProduct_id(String.valueOf(promotionId.getProductID().getProductId()));
						merchantPromotionBeaconSearchVo.setProductname(promotionId.getDescription());
						merchantPromotionBeaconSearchVo.setBrandId(promotionId.getBrandId().getBrandid());
						merchantPromotionBeaconSearchVo.setBrandName(promotionId.getBrandId().getBrandName());
						merchantPromotionBeaconSearchVo.setBrandRating(promotionId.getBrandId().getBrandRating());
						merchantPromotionBeaconSearchVo.setBrandImage(promotionId.getBrandId().getBrandImage());
						merchantPromotionBeaconSearchVo
								.setBrandDescription(promotionId.getBrandId().getBrandDescription());
						merchantPromotionBeaconSearchVo.setCatid(promotionId.getCatid().getCategoryId());
						merchantPromotionBeaconSearchVo.setCategoryName(promotionId.getCatid().getCategoryName());
					}
					if (dependentObjects.size() >= 5) {
						cities = (Cities) dependentObjects.get(5);
						merchantPromotionBeaconSearchVo.setCity(cities.getCityName());
						merchantPromotionBeaconSearchVo.setCityId(String.valueOf(cities.getCityId()));
					}
					if (dependentObjects.size() >= 4) {
						country = (Country) dependentObjects.get(4);
						merchantPromotionBeaconSearchVo.setCountry(country.getName());
						merchantPromotionBeaconSearchVo.setCountryId(String.valueOf(country.getId()));
					}
					if (dependentObjects.size() >= 2) {
						beaconId = (Beacon) dependentObjects.get(2);
						merchantPromotionBeaconSearchVo.setBeaconName(String.valueOf(beaconId.getBeaconName()));
						merchantPromotionBeaconSearchVo.setBeaconStatus(beaconId.getBeaconStatus());
					}
					if (dependentObjects.size() >= 3) {
						merchantAisle = (MerchantAisle) dependentObjects.get(3);
						merchantPromotionBeaconSearchVo.setAisleId(String.valueOf(merchantAisle.getAisleId()));
						merchantPromotionBeaconSearchVo.setAisleName(merchantAisle.getAisleName());
						merchantPromotionBeaconSearchVo.setxAxis(String.valueOf(merchantAisle.getxAxis()));
						merchantPromotionBeaconSearchVo.setyAxis(String.valueOf(merchantAisle.getyAxis()));
						merchantPromotionBeaconSearchVo.setFloor(String.valueOf(merchantAisle.getFloor()));
					}
					beaconSearchVos.add(merchantPromotionBeaconSearchVo);
				}
				result = new DataResultlist<MerchantPromotionBeaconSearchVo>(true,
						AppConstants.LIST_MERCHANT_PROMOTION_BEACONS_SUCCESS_MSG, HttpStatus.OK.value(),
						beaconSearchVos);
				return new ResponseEntity(result, HttpStatus.OK);
			} else {
				resultError = new DataResult(true, "Sorry , No data found ... ", HttpStatus.OK.value());
				return new ResponseEntity(resultError, HttpStatus.OK);
			}

		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = AppConstants.LIST_MERCHANT_PROMOTION_BEACONS, method = RequestMethod.POST)
	public ResponseEntity fetchBeaconsInformation(@RequestBody BeaconInformationVO beaconInformationVO) {
		ResponseEntity responseEntity = null;
		final String METHOD_NAME = "fetchBeaconsInformation";
		List<MPBSearchVO> mpbSearchVOs = new ArrayList<MPBSearchVO>();
		MPBSearchVO mpbSearchVO;
		PromotionDto promotionDto;
		Map<String, List<PromotionDto>> beaconsMap = new LinkedHashMap<String, List<PromotionDto>>();
		boolean mapFlag = false;
		try {
			List<MerchantPromotionBeacon> merchantPromotionBeacons = merchantPromotionBeaconService
					.fetchMerchantPromotionBeacons(beaconInformationVO);
			DataResult resultError;
			if (merchantPromotionBeacons != null) {

				for (MerchantPromotionBeacon merchantPromotionBeacon : merchantPromotionBeacons) {
					if (beaconsMap != null && !beaconsMap.isEmpty()) {
						List<PromotionDto> existingPromotion = beaconsMap
								.get(String.valueOf(merchantPromotionBeacon.getBeacon().getBeaconId()+merchantPromotionBeacon.getMerchantProfile().getId()));
						if (existingPromotion != null && !existingPromotion.isEmpty()) {
							promotionDto = new PromotionDto();
							promotionDto.setId(merchantPromotionBeacon.getPromotion().getId());
							promotionDto.setProduct_id(String.valueOf(merchantPromotionBeacon.getPromotion().getProductID().getProductId()));
							promotionDto.setDescription(merchantPromotionBeacon.getPromotion().getDescription());
							promotionDto.setMerchatId(merchantPromotionBeacon.getPromotion().getMerchatId().getId());
							promotionDto.setProduct_image(merchantPromotionBeacon.getPromotion().getProductID().getProductImageLocation());
							promotionDto.setOriginalPrice(merchantPromotionBeacon.getPromotion().getOriginalPrice());
							promotionDto.setDiscount(merchantPromotionBeacon.getPromotion().getDiscount());
							promotionDto.setLocationId(String.valueOf(merchantPromotionBeacon.getPromotion().getLocationId().getLocationId()));
							promotionDto.setLocationName(merchantPromotionBeacon.getPromotion().getLocationId().getLocationName());
							promotionDto.setCreateddate(merchantPromotionBeacon.getPromotion().getCreateddate());
							promotionDto.setStartdate(merchantPromotionBeacon.getPromotion().getStartdate());
							promotionDto.setEnddate(merchantPromotionBeacon.getPromotion().getEnddate());
							promotionDto.setCategoryName(
									merchantPromotionBeacon.getPromotion().getCatid().getCategoryName());
							promotionDto
									.setBrandName(merchantPromotionBeacon.getPromotion().getBrandId().getBrandName());
							promotionDto.setBrandRating(
									merchantPromotionBeacon.getPromotion().getBrandId().getBrandRating());
							promotionDto
									.setBrandImage(merchantPromotionBeacon.getPromotion().getBrandId().getBrandImage());
							promotionDto.setBrandDescription(
									merchantPromotionBeacon.getPromotion().getBrandId().getBrandDescription());
							promotionDto.setCatid(merchantPromotionBeacon.getPromotion().getCatid().getCategoryId());
							promotionDto.setBrandId(merchantPromotionBeacon.getPromotion().getBrandId().getBrandid());
							promotionDto.setDiscountText(merchantPromotionBeacon.getPromotion().getDiscountText());
							existingPromotion.add(promotionDto);
							mapFlag = true;
						}
					}
					if (!mapFlag) {
						mpbSearchVO = new MPBSearchVO();
						mpbSearchVO.setBeaconId(String.valueOf(merchantPromotionBeacon.getBeacon().getBeaconId()));
						mpbSearchVO.setBeaconName(merchantPromotionBeacon.getBeacon().getBeaconName());
						mpbSearchVO.setMerchantId(String.valueOf(merchantPromotionBeacon.getMerchantProfile().getId()));
						mpbSearchVO.setMerchantName(merchantPromotionBeacon.getMerchantProfile().getFirstname() + ""
								+ merchantPromotionBeacon.getMerchantProfile().getLastname());
						mpbSearchVO.setLocationId(String.valueOf(merchantPromotionBeacon.getPromotion().getLocationId().getLocationId()));
						mpbSearchVO.setLocationName(merchantPromotionBeacon.getPromotion().getLocationId().getLocationName());
						mpbSearchVO.setAisleId(String.valueOf(merchantPromotionBeacon.getMerchantAisle().getAisleId()));
						mpbSearchVO.setAisleName(merchantPromotionBeacon.getMerchantAisle().getAisleName());
						promotionDto = new PromotionDto();
						promotionDto.setId(merchantPromotionBeacon.getPromotion().getId());
						promotionDto.setProduct_id(String.valueOf(merchantPromotionBeacon.getPromotion().getProductID().getProductId()));
						promotionDto.setDescription(merchantPromotionBeacon.getPromotion().getDescription());
						promotionDto.setMerchatId(merchantPromotionBeacon.getPromotion().getMerchatId().getId());
						promotionDto.setProduct_image(merchantPromotionBeacon.getPromotion().getProductID().getProductImageLocation());
						promotionDto.setOriginalPrice(merchantPromotionBeacon.getPromotion().getOriginalPrice());
						promotionDto.setDiscount(merchantPromotionBeacon.getPromotion().getDiscount());
						promotionDto.setLocationId(String.valueOf(merchantPromotionBeacon.getPromotion().getLocationId().getLocationId()));
						promotionDto.setLocationName(String.valueOf(merchantPromotionBeacon.getPromotion().getLocationId().getLocationName()));
						promotionDto.setCreateddate(merchantPromotionBeacon.getPromotion().getCreateddate());
						promotionDto.setStartdate(merchantPromotionBeacon.getPromotion().getStartdate());
						promotionDto.setEnddate(merchantPromotionBeacon.getPromotion().getEnddate());
						promotionDto
								.setCategoryName(merchantPromotionBeacon.getPromotion().getCatid().getCategoryName());
						promotionDto.setBrandName(merchantPromotionBeacon.getPromotion().getBrandId().getBrandName());
						promotionDto
								.setBrandRating(merchantPromotionBeacon.getPromotion().getBrandId().getBrandRating());
						promotionDto.setBrandImage(merchantPromotionBeacon.getPromotion().getBrandId().getBrandImage());
						promotionDto.setBrandDescription(
								merchantPromotionBeacon.getPromotion().getBrandId().getBrandDescription());
						promotionDto.setCatid(merchantPromotionBeacon.getPromotion().getCatid().getCategoryId());
						promotionDto.setBrandId(merchantPromotionBeacon.getPromotion().getBrandId().getBrandid());
						promotionDto.setDiscountText(merchantPromotionBeacon.getPromotion().getDiscountText());
						mpbSearchVO.getPromotionDtos().add(promotionDto);
						mpbSearchVOs.add(mpbSearchVO);
						beaconsMap.put(String.valueOf(merchantPromotionBeacon.getBeacon().getBeaconId()+merchantPromotionBeacon.getMerchantProfile().getId()),
								mpbSearchVO.getPromotionDtos());
					}

				}
				DataResultlist<MPBSearchVO> result = new DataResultlist<MPBSearchVO>(true,
						AppConstants.LIST_MERCHANT_PROMOTION_BEACONS_SUCCESS_MSG, HttpStatus.OK.value(), mpbSearchVOs);
				return new ResponseEntity(result, HttpStatus.OK);
			} else {
				resultError = new DataResult(true, " Sorry , No data found ... ", HttpStatus.OK.value());
				return new ResponseEntity(resultError, HttpStatus.OK);
			}
		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		return responseEntity;
	}
}
