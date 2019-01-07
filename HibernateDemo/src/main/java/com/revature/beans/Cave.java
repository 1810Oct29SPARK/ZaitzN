package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CAVE")
public class Cave {

	public Cave(int id, String name, int maxBears) {
		super();
		this.id = id;
		this.name = name;
		this.maxBears = maxBears;
	}
	public Cave() {

	}
	
	public Cave(String name, int maxBears) {
		super();
		this.name = name;
		this.maxBears = maxBears;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "caveSequence")
	@SequenceGenerator(name="caveSequence", sequenceName="SQ_CAVE_PK", allocationSize=1)
	@Column(name="CAVE_ID")
	private int id;
	@Column(name="CAVE_NAME")
	private String name;
	@Column(name="MAX_BEARS")
	private int maxBears;
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
	public int getMaxBears() {
		return maxBears;
	}
	public void setMaxBears(int maxBears) {
		this.maxBears = maxBears;
	}
	@Override
	public String toString() {
		return "Cave [id=" + id + ", name=" + name + ", maxBears=" + maxBears + "]";
	}

}
