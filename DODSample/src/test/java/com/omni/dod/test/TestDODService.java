package com.omni.dod.test;

import java.util.Calendar;
import java.util.Date;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.omni.dod.dao.DODDao;
import com.omni.dod.dao.impl.DODDaoImpl;
import com.omni.dod.model.ConsumerRegistration;
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
		Mockito.when(dodDao.save(consumerRegistration)).thenReturn(createConsumerRegistration());
		ConsumerRegistration cr=dodService.save(consumerRegistration);
		Assert.assertEquals( Calendar.getInstance().getTime(), cr.getCreateddate());
		Assert.assertEquals( "s.binkam@omniwyse.com", cr.getEmail_id());
		System.out.println(cr.getEmail_id());
		Mockito.verify(dodDao).save(consumerRegistration);

	}
	
	public ConsumerRegistration createConsumerRegistration(){
		ConsumerRegistration consumerRegistration=new ConsumerRegistration();
		consumerRegistration.setEmail_id("s.binkam@omniwyse.com");
		consumerRegistration.setCreateddate(Calendar.getInstance().getTime());
		return consumerRegistration;
	}
}
