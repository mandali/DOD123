package com.omniwyse.dod.DTO;

import java.util.Comparator;

public class BrandComparator implements Comparator<BrandVO> {

	public int compare(BrandVO o1, BrandVO o2) {
		// TODO Auto-generated method stub
		return o1.getBrandId().compareTo(o2.getBrandId());
	}

}
