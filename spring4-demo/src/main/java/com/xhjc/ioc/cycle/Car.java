package com.xhjc.ioc.cycle;

public class Car {

	public Car(){
		System.out.println("Car's Constructor...");
	}
	
	private String brand;
	
	public void setBrand(String brand) {
		System.out.println("setBrand...");
		this.brand = brand;
	}
	
	public void init2(){
		System.out.println("init...");
	}
	
	public void destroy(){
		System.out.println("destroy...");
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + "]";
	}
	
}
