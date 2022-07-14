package com.mobile.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mobiles")
public class Mobiles {

	public Mobiles() {
		super();
	}

	public Mobiles(long id, String brandName, int count, int launchYear, String modelName, String operatingSystem,
			int price, String seller) {
		super();
		this.id = id;
		this.modelName = modelName;
		this.brandName = brandName;
		this.launchYear = launchYear;
		this.operatingSystem = operatingSystem;
		this.price = price;
		this.count = count;
		this.seller = seller;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public int getLaunchYear() {
		return launchYear;
	}

	public void setLaunchYear(int launchYear) {
		this.launchYear = launchYear;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	@Id
	@Column(name = "id")
	private long id;
	@Column(name = "model_name")
	private String modelName;
	@Column(name = "brand_name")
	private String brandName;
	@Column(name = "operating_system")
	private String operatingSystem;
	@Column(name = "launch_year")
	private int launchYear;
	@Column(name = "price")
	private int price;
	@Column(name = "count")
	private int count;
	@Column(name = "seller")
	private String seller;

	@Override
	public String toString() {
		return "Mobiles [id=" + id + ",launchYear=" + launchYear + ", modelName=" + modelName + ", brandName="
				+ brandName + ", operatingSystem=" + operatingSystem + ", price=" + price + ", count=" + count
				+ ", seller=" + seller + "]";
	}
}
