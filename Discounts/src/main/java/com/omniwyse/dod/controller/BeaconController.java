package com.omniwyse.dod.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.omniwyse.dod.AppConstants.AppConstants;
import com.omniwyse.dod.DTO.BeaconVO;
import com.omniwyse.dod.bean.DataResult;
import com.omniwyse.dod.bean.DataResultlist;
import com.omniwyse.dod.model.Beacon;
import com.omniwyse.dod.service.MetaDataService;

@RestController
public class BeaconController {

	
	private static final Logger logger = Logger.getLogger(BeaconController.class);
	
	
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
		try{
			
			List<Beacon> beacons=metaDataService.fetchBeacons();
			beaconVOs=new ArrayList<BeaconVO>();
			for(Beacon beacon:beacons){
				beaconVO=new BeaconVO();
				beaconVO.setBeaconId(beacon.getBeaconId().toString());
				beaconVO.setBeaconName(beacon.getBeaconName());
				beaconVO.setBeaconStatus(beacon.getBeaconStatus());
				beaconVO.setCreatedDate(beacon.getCreated());
				beaconVOs.add(beaconVO);
			}
			
			if(!beaconVOs.isEmpty()){
				result = new DataResultlist<BeaconVO>(true,
						AppConstants.LIST_BEACONS_SUCCESS_MSG, HttpStatus.OK.value(),
						beaconVOs);
				responseEntity=new ResponseEntity<Object>(result, HttpStatus.OK);
			}
			else {
				resultError = new DataResult(true, "Sorry , No data found ... ", HttpStatus.OK.value());
				responseEntity=new ResponseEntity<Object>(resultError, HttpStatus.OK);
			}
			
		}
		catch(Exception exception){
			logger.error("Exception in"+METHOD_NAME+""+exception.getMessage());	
		}
		return responseEntity;
		
	}
	
	
}
