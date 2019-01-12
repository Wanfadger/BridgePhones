package com.bridgePhone.model;

public class Product {
	private int id;
	private String name;
	private String category;
	private String brand;
	private int quantity;
	
	private Owner owner;

	
	
	
	
	public Product() {
		super();
	}

	public Product(int id, String name, String category, String brand, int quantity, Owner owner) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.brand = brand;
		this.quantity = quantity;
		this.owner = owner;
	}

	public Product(String name, String category, String brand, int quantity, Owner owner) {
		super();
		this.name = name;
		this.category = category;
		this.brand = brand;
		this.quantity = quantity;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	

}
