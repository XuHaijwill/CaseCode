package com.xhjc.ioc.spel;

public class Car {

	private String brand;
	private double price;
	
	//轮胎的周长
	private double tyrePerimeter;
	
	public String getBrand() {
		return brand;
	}
	public double getTyrePerimeter() {
		return tyrePerimeter;
	}
	public void setTyrePerimeter(double tyrePerimeter) {
		this.tyrePerimeter = tyrePerimeter;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + ", tyrePerimeter="
				+ tyrePerimeter + "]";
	}
	public Car() {
		System.out.println("Car's Constructor...");
	}
}
