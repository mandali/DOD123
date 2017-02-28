package com.omniwyse.dod.scheduler;

import org.springframework.scheduling.annotation.Scheduled;

public class PromotionScheduler {
	
	@Scheduled(fixedDelay=1800000)
	public void startPromotionScheduler(){
		System.out.println("In startPromotionScheduler");
	}

}
