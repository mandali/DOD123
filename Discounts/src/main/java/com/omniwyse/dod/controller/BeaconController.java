package com.omniwyse.dod.controller;

import java.util.ArrayList;
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
import com.omniwyse.dod.DTO.AliseVO;
import com.omniwyse.dod.DTO.BeaconVO;
import com.omniwyse.dod.DTO.IAliseVO;
import com.omniwyse.dod.bean.DataResult;
import com.omniwyse.dod.bean.DataResultlist;
import com.omniwyse.dod.model.Beacon;
import com.omniwyse.dod.model.MerchantAisle;
import com.omniwyse.dod.service.MetaDataService;

@RestController
public class BeaconController {

	private static final Logger logger = Logger.getLogger(BeaconController.class);
	private static final String CLASS_NAME = BeaconController.class.getName();
	@Autowired
	MetaDataService metaDataService;

	@RequestMapping(value = AppConstants.LIST_BEACONS, method = RequestMethod.GET)
	public ResponseEntity<Object> fetchBeacons() {
		ResponseEntity<Object> responseEntity = null;
		final String METHOD_NAME = "fetchBeacons";
		DataResult resultError;
		BeaconVO beaconVO;
		List<BeaconVO> beaconVOs;
		DataResultlist<BeaconVO> result;
		try {
			logger.debug("Entering " + CLASS_NAME + " " + METHOD_NAME);

			List<Beacon> beacons = metaDataService.fetchBeacons();
			beaconVOs = new ArrayList<BeaconVO>();
			for (Beacon beacon : beacons) {
				beaconVO = new BeaconVO();
				beaconVO.setBeaconId(beacon.getBeaconId().toString());
				beaconVO.setBeaconName(beacon.getBeaconName());
				beaconVO.setBeaconStatus(beacon.getBeaconStatus());
				beaconVO.setCreatedDate(beacon.getCreated());
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
			logger.error("Exception in " + CLASS_NAME + " + METHOD_NAME + " + exception.getMessage());
		}
		logger.debug("Exiting " + CLASS_NAME + " " + METHOD_NAME);
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
			logger.debug("Entering " + CLASS_NAME + " " + METHOD_NAME);
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
			logger.error("Exception in " + CLASS_NAME + " + METHOD_NAME + " + exception.getMessage());
		}

		logger.debug("Exiting " + CLASS_NAME + " " + METHOD_NAME);

		return responseEntity;
	}

}
