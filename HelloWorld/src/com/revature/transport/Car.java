package com.revature.transport;

import java.io.Serializable;

public class Car extends Vehicle implements Steerable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7887597342860831034L;

	public Car(int yearManufactured, String model, String make, double milesSinceOilChange) {
		super();
		this.yearManufactured = yearManufactured;
		this.model = model;
		this.make = make;
		this.milesSinceOilChange = milesSinceOilChange;
	}

	public Car() {
		super(); // calls Vehicle()
	}

	public static final int recommendedMilesBetweenOilChanges = 5000;

	private int yearManufactured;
	private String model;
	private String make;
	private double milesSinceOilChange;

	@Override
	public void move() throws MaintenanceException {
		if(this.milesSinceOilChange >= recommendedMilesBetweenOilChanges) {
			throw new MaintenanceException("oil needs to be changed");
		}
		System.out.println("car is moving");
	}

	public int getYearManufactured() {
		return yearManufactured;
	}

	public void setYearManufactured(int yearManufactured) {
		this.yearManufactured = yearManufactured;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public double getMilesSinceOilChange() {
		return milesSinceOilChange;
	}

	public void setMilesSinceOilChange(int milesSinceOilChange) {
		this.milesSinceOilChange = milesSinceOilChange;
	}

	@Override
	public String toString() {
		return "Car [yearManufactured=" + yearManufactured + ", model=" + model + ", make=" + make
				+ ", milesSinceOilChange=" + milesSinceOilChange + "]";
	}

	@Override
	public void turnRight() {
		System.out.println("turn wheel clockwise");
		
	}

	@Override
	public void turnLeft() {
		System.out.println("turn wheel counter-clockwise");
		
	}

}
