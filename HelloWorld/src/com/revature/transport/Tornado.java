package com.revature.transport;

public class Tornado extends Vehicle {

	public Tornado(double maxWindSpeed) {
		super();
		this.maxWindSpeed = maxWindSpeed;
	}

	public Tornado() {
	}
	
	private double maxWindSpeed;

	public double getMaxWindSpeed() {
		return maxWindSpeed;
	}

	public void setMaxWindSpeed(double maxWindSpeed) {
		this.maxWindSpeed = maxWindSpeed;
	}

	@Override
	public void move() {
		System.out.println("DESTROYING THE CITY");

	}

}
