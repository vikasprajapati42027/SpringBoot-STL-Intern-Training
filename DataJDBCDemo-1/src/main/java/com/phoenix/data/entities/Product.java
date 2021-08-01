package com.phoenix.data.entities;



import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;

/*
 * @author : vikas .prajapati@stltech.in
 * @version: 0.1
 * @Date 29-07-2021
 * @Copyright Sterlite Technology Ltd.
 * 
 */
public class Product implements Persistable<Integer> {

	@Id
	private int id;
	private String name;
	private String brand;
	private float price;
	
	@Transient
	private boolean isInsert;
	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String name, String brand, float price) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
	}

	/*
	 * public int getId() { return id; }
	 */

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price + "]";
	}
	//persistable method implemented

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return isInsert;
	}

	public boolean isInsert() {
		return isInsert;
	}

	public void setInsert(boolean isInsert) {
		this.isInsert = isInsert;
	}
	
	
	
}
