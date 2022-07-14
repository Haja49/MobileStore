package com.mobile.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.demo.model.Mobiles;
import com.mobile.demo.service.MobileService;

@RestController
@RequestMapping("/api/v1")
public class MobileController {

	@Autowired
	private MobileService mobileService;

	@GetMapping("/mobiles/{modelName}/{brandName}")
	public ResponseEntity<List<Mobiles>> findByModelNameAndBrandName(@PathVariable("modelName") String modelName,
			@PathVariable("brandName") String brandName) {
		try {
			List<Mobiles> mobiles = new ArrayList<Mobiles>();
			mobileService.findByModelNameAndBrandName(modelName, brandName).forEach(mobiles::add);
			if (mobiles.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(mobiles, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/mobiles/{modelName}")
	public ResponseEntity<List<Mobiles>> findByModelNameOrBrandName(@PathVariable("modelName") String modelName) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(mobileService.findByModelNameOrBrandName(modelName, modelName));
	}

	@GetMapping("/maxsold/{launchYear}")
	public List<Mobiles> findBy(@PathVariable("launchYear") int launchYear) {
		return mobileService.findByLaunchYear(launchYear);
	}

	@GetMapping("/mobiles")
	public List<Mobiles> findBy() {
		return mobileService.findMobiles();
	}

	@PostMapping("/mobiles")
	public ResponseEntity<Mobiles> createTutorial(@RequestBody Mobiles mobiles) {
		try {
			Mobiles addMobiles = mobileService.save(mobiles);
			return new ResponseEntity<>(addMobiles, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
