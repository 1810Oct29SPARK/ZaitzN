package com.revature.transport;

public class Tornado extends Vehicle {

	public Tornado(double maxWindSpeed) {
		super();
		this.maxWindSpeed = maxWindSpeed;
	}

	public Tornado() {
	}
	
	private double maxWindSpeed;
	private boolean isInSupercell;

	public double getMaxWindSpeed() {
		return maxWindSpeed;
	}

	public void setMaxWindSpeed(double maxWindSpeed) {
		this.maxWindSpeed = maxWindSpeed;
	}

	@Override
	public void move() throws MaintenanceException {
		if(!this.isInSupercell) {
			throw new MaintenanceException("weather machine incorrectly configured");
		}
		System.out.println("DESTROYING THE CITY");

	}

}
