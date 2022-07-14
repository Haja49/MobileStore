package com.mobile.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.demo.model.Mobiles;
import com.mobile.demo.repository.MobileRepository;

@Service
public class MobileService {
	@Autowired
	MobileRepository mobileRepo;
	
	public List<Mobiles> findByModelNameAndBrandName(String modelName, String brandName){
		return mobileRepo.findByModelNameAndBrandName(modelName, brandName);
	}
	
	public List<Mobiles> findByModelNameOrBrandName(String modelName, String brandName){
		return mobileRepo.findByModelNameOrBrandName(modelName, brandName);
	}

	public List<Mobiles> findByLaunchYear(int launchYear){
		return mobileRepo.findByLaunchYear(launchYear);
	}
	
	public List<Mobiles> findMobiles(){
		return mobileRepo.findMobiles();
		
	}
	
	public Mobiles save(Mobiles mobiles) {
		return mobileRepo.save(mobiles);
	}
}
