package com.omni.dod.test;

import java.util.Calendar;
import java.util.Date;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.omni.dod.dao.DODDao;
import com.omni.dod.dao.impl.DODDaoImpl;
import com.omni.dod.model.ConsumerRegistration;
import com.omni.dod.model.RegisterWithOtp;
import com.omni.dod.service.DODService;
import com.omni.dod.service.impl.DODServiceImpl;

public class TestDODService {

	@InjectMocks
	private DODServiceImpl dodService;
	
	@Mock
	private DODDaoImpl dodDao;
	
	@BeforeMethod
	public void initMocks(){
		MockitoAnnotations.initMocks(this);		
	}
	
	
	@Test
	public void testsave(){
		ConsumerRegistration consumerRegistration=new ConsumerRegistration();
		consumerRegistration.setEmail_id("s.binkam@omniwyse.com");
		consumerRegistration.setCreateddate(Calendar.getInstance().getTime());
		Mockito.when(dodDao.save(consumerRegistration)).thenReturn(createConsumerRegistration(consumerRegistration));
		ConsumerRegistration cr=dodService.save(consumerRegistration);
		Assert.assertEquals( Calendar.getInstance().getTime(), cr.getCreateddate());
		Assert.assertEquals("s.binkam@omniwyse.com", cr.getEmail_id());

	}
	
	public ConsumerRegistration createConsumerRegistration(ConsumerRegistration consumerRegistration){
		ConsumerRegistration cr=new ConsumerRegistration();
		cr.setEmail_id(consumerRegistration.getEmail_id());
		cr.setCreateddate(consumerRegistration.getCreateddate());
		return cr;
	}
	
	@Test
	public void testSavewithotp(){
		RegisterWithOtp regOTP=new RegisterWithOtp();
		Date date=new Date();
		regOTP.setExpdate(date);
		regOTP.setUser_id("sam");
		regOTP.setCreatedate(date);
		regOTP.setOtpno("1234");
		Mockito.when(dodDao.savewithotp(regOTP)).thenReturn(regOTP);
		RegisterWithOtp registerWithOtp=dodService.savewithotp(regOTP);
		Assert.assertEquals("1234", registerWithOtp.getOtpno());
		Assert.assertEquals("sam", registerWithOtp.getUser_id());
	}
}
