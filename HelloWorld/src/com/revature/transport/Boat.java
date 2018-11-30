package com.revature.transport;

public class Boat extends Vehicle implements Steerable {
	
	public Boat(String color, double hullLengthInMeters) {
		this();
		this.color = color;
		this.hullLengthInMeters = hullLengthInMeters;
		System.out.println("boat args constructor completed");
	}

	public Boat() {
		super();
		System.out.println("boat noargs constructor completed");
	}

	protected String color;
	protected double hullLengthInMeters;
	protected boolean hasHoleInHull;

	@Override
	public void move() throws MaintenanceException {
		if (this.hasHoleInHull) {
			throw new MaintenanceException("unseaworthy");
		}
		System.out.println("Boat is moving");
		
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getHullLengthInMeters() {
		return hullLengthInMeters;
	}

	public void setHullLengthInMeters(double hullLengthInMeters) {
		this.hullLengthInMeters = hullLengthInMeters;
	}

	@Override
	public void turnRight() {
		System.out.println("paddle left");
	}

	@Override
	public void turnLeft() {
		System.out.println("paddle right");
	}

	public boolean isHasHoleInHull() {
		return hasHoleInHull;
	}

	public void setHasHoleInHull(boolean hasHoleInHull) {
		this.hasHoleInHull = hasHoleInHull;
	}
	

}
