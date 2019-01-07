package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MOONS")
public class Moon {

	public Moon(int id, String name, Planet planetId) {
		super();
		this.id = id;
		this.name = name;
		this.planetId = planetId;
	}
	
	public Moon(int id) {
		// TODO Auto-generated constructor stub
	}
	
	public Moon() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "moonSequence")
	@SequenceGenerator(name="moonSequence", sequenceName="SQ_MOON_ID_PK", allocationSize=1)
	@Column(name="ID")
	private int id;
	
	@Column(name="MOON_NAME")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="PLANET_ID", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private Planet planetId;
	
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
	public Planet getPlanetId() {
		return planetId;
	}
	public void setPlanetId(Planet planetId) {
		this.planetId = planetId;
	}
	
	@Override
	public String toString() {
		return "Moon [id=" + id + ", name=" + name + ", planetId=" + planetId + "]";
	}
	
}
