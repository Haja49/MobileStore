package com.mobile.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobile.demo.model.Mobiles;

@Repository
public interface MobileRepository extends CrudRepository<Mobiles, Long> {

	@Query(value = "SELECT * FROM MOBILES", nativeQuery = true)
	public List<Mobiles> findMobiles();

	public List<Mobiles> findByModelNameAndBrandName(String modelName, String brandName);

	public List<Mobiles> findByModelNameOrBrandName(String modelName, String brandName);

	public List<Mobiles> findByLaunchYear(int launchYear);
}
