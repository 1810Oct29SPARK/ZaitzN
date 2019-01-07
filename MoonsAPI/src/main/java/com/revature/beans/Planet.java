package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PLANETS")
public class Planet {
	
	public Planet(int id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}
	
	public Planet(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}
	
	public Planet() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "planetSequence")
	@SequenceGenerator(name="planetSequence", sequenceName="SQ_PLANET_ID_PK", allocationSize=1)
	@Column(name="PLANET_ID")
	private int id;
	@Column(name="PLANET_NAME")
	private String name;
	@Column(name="PLANET_LOCATION")
	private String location;
	
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "Planet [id=" + id + ", name=" + name + ", location=" + location + "]";
	}

}
