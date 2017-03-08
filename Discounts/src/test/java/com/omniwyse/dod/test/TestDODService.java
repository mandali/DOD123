package com.omniwyse.dod.test;

import java.util.Date;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.omniwyse.dod.dao.RegistrationDao;
import com.omniwyse.dod.dao.impl.ConsumerDaoImpl;
import com.omniwyse.dod.model.ConsumerProfile;
import com.omniwyse.dod.model.RegisterWithOtp;
import com.omniwyse.dod.service.impl.ConsumerServiceImpl;
import com.omniwyse.dod.service.impl.RegistrationServiceImpl;

public class TestDODService {

	@InjectMocks
	private ConsumerServiceImpl consumerServiceImpl;
	
	@Mock
	private ConsumerDaoImpl consumerDaoImpl;
	
	@InjectMocks
	private RegistrationServiceImpl RegistrationServiceImpl;
	
	@Mock
	private RegistrationDao registrationDao;
	
	@BeforeMethod
	public void initMocks(){
		MockitoAnnotations.initMocks(this);		
	}
	
	
	@Test
	public void testsave(){
		ConsumerProfile consumerRegistration=new ConsumerProfile();
		consumerRegistration.setEmail_id("s.binkam@omniwyse.com");
		consumerRegistration.setPhone_no("9876543210");
		Mockito.when(consumerDaoImpl.registerconsumer(consumerRegistration)).thenReturn(createConsumerProfile(consumerRegistration));
		ConsumerProfile cr=consumerServiceImpl.registerconsumer(consumerRegistration);
		Assert.assertEquals( consumerRegistration.getPhone_no(), cr.getPhone_no());
		Assert.assertEquals("s.binkam@omniwyse.com", cr.getEmail_id());

	}
	
	public ConsumerProfile createConsumerProfile(ConsumerProfile consumerRegistration){
		ConsumerProfile cr=new ConsumerProfile();
		cr.setEmail_id(consumerRegistration.getEmail_id());
		cr.setPhone_no(consumerRegistration.getPhone_no());
		return cr;
	}
	
	@Test
	public void testSavewithotp(){
		RegisterWithOtp regOTP=new RegisterWithOtp();
		Date date=new Date();
		regOTP.setExpdate(date);
		regOTP.setUser_id("9491779827");
		regOTP.setCreatedate(date);
		regOTP.setOtpno("1234");
		Mockito.when(registrationDao.register(regOTP)).thenReturn(regOTP);
		RegisterWithOtp registerWithOtp=RegistrationServiceImpl.register(regOTP);
		Assert.assertEquals("1234", registerWithOtp.getOtpno());
		Assert.assertEquals("9491779827", registerWithOtp.getUser_id());
	}
}
