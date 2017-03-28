package com.omniwyse.dod.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.omniwyse.dod.AppConstants.AppConstants;
import com.omniwyse.dod.DTO.AliseVO;
import com.omniwyse.dod.DTO.BeaconInformationVO;
import com.omniwyse.dod.DTO.BeaconVO;
import com.omniwyse.dod.DTO.IAliseVO;
import com.omniwyse.dod.DTO.IBeaconVO;
import com.omniwyse.dod.DTO.MPBSearchVO;
import com.omniwyse.dod.DTO.NewProductVO;
import com.omniwyse.dod.DTO.PromotionDto;
import com.omniwyse.dod.bean.DataResult;
import com.omniwyse.dod.bean.DataResultlist;
import com.omniwyse.dod.model.Beacon;
import com.omniwyse.dod.model.MerchantAisle;
import com.omniwyse.dod.model.MerchantBeacon;
import com.omniwyse.dod.model.MerchantPromotionBeacon;
import com.omniwyse.dod.service.MerchantPromotionBeaconService;
import com.omniwyse.dod.service.MetaDataService;
@CrossOrigin(origins = "*")
@RestController
public class BeaconController {

	private static final Logger LOGGER = Logger.getLogger(BeaconController.class);
	private static final String CLASS_NAME = BeaconController.class.getName();
	@Autowired
	MetaDataService metaDataService;
	@Autowired
	MerchantPromotionBeaconService merchantPromotionBeaconService;

	@RequestMapping(value = AppConstants.LIST_BEACONS, method = RequestMethod.GET)
	public ResponseEntity<Object> fetchBeacons() {
		ResponseEntity<Object> responseEntity = null;
		final String METHOD_NAME = "fetchBeacons";
		DataResult resultError;
		BeaconVO beaconVO;
		List<BeaconVO> beaconVOs;
		DataResultlist<BeaconVO> result;
		try {
			List<Beacon> beacons = metaDataService.fetchBeacons();
			beaconVOs = new ArrayList<BeaconVO>();
			for (Beacon beacon : beacons) {
				beaconVO = new BeaconVO();
				beaconVO.setBeaconId(beacon.getBeaconId().toString());
				beaconVO.setBeaconName(beacon.getBeaconName());
				beaconVO.setBeaconStatus(beacon.getBeaconStatus());
				beaconVO.setCreatedDate(beacon.getCreated());
				beaconVO.setBeaconUid(String.valueOf(beacon.getUid()));
				beaconVO.setBeaconMajorValue(String.valueOf(beacon.getMajor()));
				beaconVO.setBeaconMinorValue(String.valueOf(beacon.getMinor()));
				beaconVOs.add(beaconVO);
			}

			if (!beaconVOs.isEmpty()) {
				result = new DataResultlist<BeaconVO>(true, AppConstants.LIST_BEACONS_SUCCESS_MSG,
						HttpStatus.OK.value(), beaconVOs);
				responseEntity = new ResponseEntity<Object>(result, HttpStatus.OK);
			} else {
				resultError = new DataResult(false, "Sorry , No data found ... ", HttpStatus.OK.value());
				responseEntity = new ResponseEntity<Object>(resultError, HttpStatus.OK);
			}

		} catch (Exception exception) {
			LOGGER.error("Exception in " + CLASS_NAME + " + METHOD_NAME + " + exception.getMessage());
		}
		LOGGER.debug("Exiting " + CLASS_NAME + " " + METHOD_NAME);
		return responseEntity;

	}

	@RequestMapping(value = AppConstants.LIST_AISLE, method = RequestMethod.POST)
	public ResponseEntity<Object> fetchAisle(@RequestBody IAliseVO ialiseVO) {
		final String METHOD_NAME = "fetchAisle";
		ResponseEntity<Object> responseEntity = null;
		DataResult resultError;
		AliseVO aliseVO;
		List<AliseVO> aliseVOs = null;
		List<MerchantAisle> aisles = null;
		DataResultlist<AliseVO> result;
		try {
			LOGGER.debug("Entering " + CLASS_NAME + " " + METHOD_NAME);
			if (ialiseVO.getMerchantId() != null && !ialiseVO.getMerchantId().isEmpty()) {

				aisles = metaDataService.fetchAisle(ialiseVO.getMerchantId());
			}

			if (aisles != null && !aisles.isEmpty()) {
				aliseVOs = new ArrayList<AliseVO>();
				for (MerchantAisle merchantAisle : aisles) {
					aliseVO = new AliseVO();
					aliseVO.setAliseId(String.valueOf(merchantAisle.getAisleId()));
					aliseVO.setAliseName(merchantAisle.getAisleName());
					aliseVO.setFloor(String.valueOf(merchantAisle.getFloor()));
					aliseVO.setxAxis(String.valueOf(merchantAisle.getxAxis()));
					aliseVO.setyAxis(String.valueOf(merchantAisle.getyAxis()));
					aliseVOs.add(aliseVO);

				}

			}

			if (aliseVOs != null && !aliseVOs.isEmpty()) {
				result = new DataResultlist<AliseVO>(true, AppConstants.LIST_AISLE_SUCCESS_MSG, HttpStatus.OK.value(),
						aliseVOs);
				responseEntity = new ResponseEntity<Object>(result, HttpStatus.OK);

			} else {
				resultError = new DataResult(false, "Sorry , No data found ... ", HttpStatus.OK.value());
				responseEntity = new ResponseEntity<Object>(resultError, HttpStatus.OK);

			}

		}

		catch (Exception exception) {
			LOGGER.error("Exception in " + CLASS_NAME + " + METHOD_NAME + " + exception.getMessage());
		}

		LOGGER.debug("Exiting " + CLASS_NAME + " " + METHOD_NAME);

		return responseEntity;
	}

		
	@RequestMapping(value = AppConstants.LIST_BEACONS_BY_MERCHANTIS, method = RequestMethod.POST)
	public ResponseEntity<Object> fetchMerchantBeacons(@RequestBody NewProductVO merchantId) {
		ResponseEntity<Object> responseEntity = null;
		final String METHOD_NAME = "fetchBeacons";
		DataResult resultError;
		BeaconVO beaconVO;
		List<BeaconVO> beaconVOs = null;
		DataResultlist<BeaconVO> result;
		try {
			LOGGER.debug("Entering " + CLASS_NAME + " " + METHOD_NAME);
           if(merchantId.getMerchantId()!=null && !merchantId.getMerchantId().isEmpty()){
			List<MerchantBeacon> beacons = metaDataService.fetchMerchantBeacons(merchantId.getMerchantId());
			beaconVOs = new ArrayList<BeaconVO>();
			for (MerchantBeacon beacon : beacons) {
				beaconVO = new BeaconVO();
				beaconVO.setBeaconId(String.valueOf(beacon.getBeaconId().getBeaconId()));
				beaconVO.setBeaconName(beacon.getBeaconId().getBeaconName());
				beaconVO.setBeaconStatus(beacon.getBeaconId().getBeaconStatus());
				beaconVO.setCreatedDate(beacon.getBeaconId().getCreated());
				beaconVO.setBeaconUid(String.valueOf(beacon.getBeaconId().getUid()));
				beaconVO.setBeaconMajorValue(String.valueOf(beacon.getBeaconId().getMajor()));
				beaconVO.setBeaconMinorValue(String.valueOf(beacon.getBeaconId().getMinor()));
				beaconVOs.add(beaconVO);
			}
			
           }

			if (beaconVOs!=null && !beaconVOs.isEmpty()) {
				result = new DataResultlist<BeaconVO>(true, AppConstants.LIST_BEACONS_INFO_SUCCESS_MSG,
						HttpStatus.OK.value(), beaconVOs);
				responseEntity = new ResponseEntity<Object>(result, HttpStatus.OK);
			} else {
				resultError = new DataResult(false, "Sorry , No data found ... ", HttpStatus.OK.value());
				responseEntity = new ResponseEntity<Object>(resultError, HttpStatus.OK);
			}

		} catch (Exception exception) {
			LOGGER.error("Exception in " + CLASS_NAME + " + METHOD_NAME + " + exception.getMessage());
		}
		LOGGER.debug("Exiting " + CLASS_NAME + " " + METHOD_NAME);
		return responseEntity;

	}
	
	
	@RequestMapping(value = AppConstants.LIST_BEACONS_INFO, method = RequestMethod.POST)
	public ResponseEntity<Object> fetchBeaconsByInfo(@RequestBody String jsonArray) {
		ResponseEntity<Object> responseEntity = null;
		final String METHOD_NAME = "fetchBeacons";
		DataResult resultError;
		BeaconVO beaconVO;
		List<BeaconVO> beaconVOs = null;
		DataResultlist<MPBSearchVO> result;
		Gson gson = new Gson();
		List<String> buid = new ArrayList<String>();
		List<Integer> bmajor = new ArrayList<Integer>();
		List<Integer> bminor = new ArrayList<Integer>();
		List<Beacon> beacons = null;
		TypeToken<List<IBeaconVO>> token;
		List<IBeaconVO> iBeaconVOs = null;
		boolean parseFlag = false;
		List<MPBSearchVO> mpbSearchVOs = new ArrayList<MPBSearchVO>();
		MPBSearchVO mpbSearchVO;
		PromotionDto promotionDto;
		Map<String, MPBSearchVO> beaconsMap = new LinkedHashMap<String, MPBSearchVO>();
		boolean mapFlag = false;
		BeaconInformationVO beaconInformationVO;
		List<MerchantPromotionBeacon> merchantPromotionBeacons = null;
		StringBuilder validData;
		try {
			LOGGER.debug("Entering " + CLASS_NAME + " " + METHOD_NAME);
			try {
				token = new TypeToken<List<IBeaconVO>>() {
				};
				iBeaconVOs = gson.fromJson(jsonArray, token.getType());
			} catch (Exception exception) {
				parseFlag = true;
				LOGGER.error("Exception in " + CLASS_NAME + " + METHOD_NAME + " + exception.getMessage());
			}
			if (iBeaconVOs != null && !iBeaconVOs.isEmpty() && !parseFlag) {

				for (IBeaconVO iBeaconVO : iBeaconVOs) {
					buid.add(iBeaconVO.getBeaconUID() != null ? iBeaconVO.getBeaconUID() : "");
					String maxValue = iBeaconVO.getBeaconMajorValue() != null ? iBeaconVO.getBeaconMajorValue() : "";
					if (maxValue != null && !maxValue.isEmpty()) {
						bmajor.add(Integer.parseInt(maxValue));
					}
					String minValue = iBeaconVO.getBeaconMinorValue() != null ? iBeaconVO.getBeaconMinorValue() : "";
					if (minValue != null && !minValue.isEmpty()) {
						bminor.add(Integer.parseInt(minValue));
					}

				}
			}

			if (!buid.isEmpty() && !bmajor.isEmpty() && !bminor.isEmpty()) {
				beacons = metaDataService.fetchBeaconByUidMajorMinor(buid, bmajor, bminor);
			}

			if (beacons!=null && !beacons.isEmpty() && beacons.size() > 0) {
				beaconVOs = new ArrayList<BeaconVO>();
				for (Beacon beacon : beacons) {

					beaconVO = new BeaconVO();
					beaconVO.setBeaconId(String.valueOf(beacon.getBeaconId()));
					beaconVO.setBeaconMajorValue(String.valueOf(beacon.getMajor()));
					beaconVO.setBeaconMinorValue(String.valueOf(beacon.getMinor()));
					beaconVO.setBeaconName(String.valueOf(beacon.getBeaconName()));
					beaconVO.setBeaconStatus(beacon.getBeaconStatus());
					beaconVO.setBeaconUid(beacon.getUid());
					beaconVO.setCreatedDate(beacon.getCreated());
					beaconVOs.add(beaconVO);
				}

			}

			if (beaconVOs != null && !beaconVOs.isEmpty()) {
				beaconInformationVO = new BeaconInformationVO();

				for (BeaconVO beaconVOLocal : beaconVOs) {
					beaconInformationVO.getBeaconIds().add(beaconVOLocal.getBeaconId());

				}

				if (beaconInformationVO != null && !beaconInformationVO.getBeaconIds().isEmpty()) {

					merchantPromotionBeacons = merchantPromotionBeaconService
							.fetchMerchantPromotionBeacons(beaconInformationVO);
				}

				if (merchantPromotionBeacons != null && !merchantPromotionBeacons.isEmpty()) {

					for (MerchantPromotionBeacon merchantPromotionBeacon : merchantPromotionBeacons) {
						if (beaconsMap != null && !beaconsMap.isEmpty()) {
							StringBuilder validateData=new StringBuilder();
							validateData.append(merchantPromotionBeacon.getBeacon().getBeaconId()).append(merchantPromotionBeacon.getMerchantProfile().getMerchantId());
							MPBSearchVO existingPromotion = beaconsMap.get(validateData.toString());
							if (existingPromotion != null && !existingPromotion.getPromotionDtos().isEmpty()) {
								existingPromotion.setBeaconId(String.valueOf(merchantPromotionBeacon.getBeacon().getBeaconId()));
								existingPromotion.setBeaconName(merchantPromotionBeacon.getBeacon().getBeaconName());
								existingPromotion.setMerchantId(
										String.valueOf(merchantPromotionBeacon.getMerchantProfile().getMerchantId()));
								existingPromotion.setMerchantName(merchantPromotionBeacon.getMerchantProfile().getFirstname() + ""
										+ merchantPromotionBeacon.getMerchantProfile().getLastname());
								existingPromotion.setLocationId(String
										.valueOf(merchantPromotionBeacon.getPromotion().getLocationId().getLocationId()));
								existingPromotion.setLocationName(
										merchantPromotionBeacon.getPromotion().getLocationId().getLocationName());
								existingPromotion.setAisleId(
										String.valueOf(merchantPromotionBeacon.getMerchantAisle().getAisleId()));
								existingPromotion.setAisleName(merchantPromotionBeacon.getMerchantAisle().getAisleName());
								promotionDto = new PromotionDto();
								promotionDto.setId(merchantPromotionBeacon.getPromotion().getId());
								promotionDto.setProduct_id(String
										.valueOf(merchantPromotionBeacon.getPromotion().getProductID().getProductId()));
								promotionDto.setDescription(merchantPromotionBeacon.getPromotion().getDescription());
								promotionDto
										.setMerchatId(merchantPromotionBeacon.getPromotion().getMerchatId().getMerchantId());
								promotionDto.setProduct_image(merchantPromotionBeacon.getPromotion().getProductID()
										.getProductImageLocation());
								promotionDto
										.setOriginalPrice(merchantPromotionBeacon.getPromotion().getOriginalPrice());
								promotionDto.setDiscount(merchantPromotionBeacon.getPromotion().getDiscount());
								promotionDto.setLocationId(String.valueOf(
										merchantPromotionBeacon.getPromotion().getLocationId().getLocationId()));
								promotionDto.setLocationName(
										merchantPromotionBeacon.getPromotion().getLocationId().getLocationName());
								promotionDto.setCreateddate(merchantPromotionBeacon.getPromotion().getCreateddate());
								promotionDto.setStartdate(merchantPromotionBeacon.getPromotion().getStartdate());
								promotionDto.setEnddate(merchantPromotionBeacon.getPromotion().getEnddate());
								promotionDto.setCategoryName(
										merchantPromotionBeacon.getPromotion().getCatid().getCategoryName());
								promotionDto.setBrandName(
										merchantPromotionBeacon.getPromotion().getBrandId().getBrandName());
								promotionDto.setBrandRating(
										merchantPromotionBeacon.getPromotion().getBrandId().getBrandRating());
								promotionDto.setBrandImage(
										merchantPromotionBeacon.getPromotion().getBrandId().getBrandImage());
								promotionDto.setBrandDescription(
										merchantPromotionBeacon.getPromotion().getBrandId().getBrandDescription());
								promotionDto
										.setCatid(merchantPromotionBeacon.getPromotion().getCatid().getCategoryId());
								promotionDto
										.setBrandId(merchantPromotionBeacon.getPromotion().getBrandId().getBrandid());
								promotionDto.setDiscountText(merchantPromotionBeacon.getPromotion().getDiscountText());
								existingPromotion.getPromotionDtos().add(promotionDto);
								mapFlag = true;
							}
						}
						if (!mapFlag) {
							validData=new StringBuilder();
							mpbSearchVO = new MPBSearchVO();
							mpbSearchVO.setBeaconId(String.valueOf(merchantPromotionBeacon.getBeacon().getBeaconId()));
							mpbSearchVO.setBeaconName(merchantPromotionBeacon.getBeacon().getBeaconName());
							mpbSearchVO.setMerchantId(
									String.valueOf(merchantPromotionBeacon.getMerchantProfile().getMerchantId()));
							mpbSearchVO.setMerchantName(merchantPromotionBeacon.getMerchantProfile().getFirstname() + ""
									+ merchantPromotionBeacon.getMerchantProfile().getLastname());
							mpbSearchVO.setLocationId(String
									.valueOf(merchantPromotionBeacon.getPromotion().getLocationId().getLocationId()));
							mpbSearchVO.setLocationName(
									merchantPromotionBeacon.getPromotion().getLocationId().getLocationName());
							mpbSearchVO.setAisleId(
									String.valueOf(merchantPromotionBeacon.getMerchantAisle().getAisleId()));
							mpbSearchVO.setAisleName(merchantPromotionBeacon.getMerchantAisle().getAisleName());
							promotionDto = new PromotionDto();
							promotionDto.setId(merchantPromotionBeacon.getPromotion().getId());
							promotionDto.setProduct_id(String
									.valueOf(merchantPromotionBeacon.getPromotion().getProductID().getProductId()));
							promotionDto.setDescription(merchantPromotionBeacon.getPromotion().getDescription());
							promotionDto.setMerchatId(merchantPromotionBeacon.getPromotion().getMerchatId().getMerchantId());
							promotionDto.setProduct_image(
									merchantPromotionBeacon.getPromotion().getProductID().getProductImageLocation());
							promotionDto.setOriginalPrice(merchantPromotionBeacon.getPromotion().getOriginalPrice());
							promotionDto.setDiscount(merchantPromotionBeacon.getPromotion().getDiscount());
							promotionDto.setLocationId(String
									.valueOf(merchantPromotionBeacon.getPromotion().getLocationId().getLocationId()));
							promotionDto.setLocationName(String
									.valueOf(merchantPromotionBeacon.getPromotion().getLocationId().getLocationName()));
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
							mpbSearchVO.getPromotionDtos().add(promotionDto);
							mpbSearchVOs.add(mpbSearchVO);
							validData.append(merchantPromotionBeacon.getBeacon().getBeaconId()).append(merchantPromotionBeacon.getMerchantProfile().getMerchantId());
							beaconsMap.put(
									validData.toString(),
									mpbSearchVO);
						}
							mapFlag=false;
					}
				
				}
				
			}			
			if(mpbSearchVOs!=null && !mpbSearchVOs.isEmpty()){
				result = new DataResultlist<MPBSearchVO>(true,
						AppConstants.LIST_MERCHANT_PROMOTION_BEACONS_SUCCESS_MSG, HttpStatus.OK.value(),
						mpbSearchVOs);
				return new ResponseEntity<Object>(result, HttpStatus.OK);
			}
			 else {
				resultError = new DataResult(false, " Sorry , No data found ... ", HttpStatus.OK.value());
				return new ResponseEntity<Object>(resultError, HttpStatus.OK);

			}

		} catch (Exception exception) {
			LOGGER.error("Exception in " + CLASS_NAME + " + METHOD_NAME + " + exception.getMessage());
		}
		LOGGER.debug("Exiting " + CLASS_NAME + " " + METHOD_NAME);

		return responseEntity;

	}

}
