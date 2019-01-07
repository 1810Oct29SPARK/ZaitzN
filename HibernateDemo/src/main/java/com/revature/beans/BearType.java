package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BEAR_TYPE")
public class BearType {

	public BearType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public BearType() {

	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "bearTypeSequence")
	@SequenceGenerator(name="bearTypeSequence", sequenceName="SQ_BEAR_TYPE_PK", allocationSize=1)
	@Column(name="BEAR_TYPE_ID")
	private int id;
	
	@Column(name="BEAR_TYPE_NAME")
	private String name;
	
	
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
	@Override
	public String toString() {
		return "BearType [id=" + id + ", name=" + name + "]";
	}
}
