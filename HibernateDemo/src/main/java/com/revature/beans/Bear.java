package com.revature.beans;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="getAllBears", query="from Bear"),
	@NamedQuery(name="getBearsByType", query="from Bear where bearType.id=:id")
})

@Entity
@Table(name="BEAR")
public class Bear {

	public Bear(int id, String name, Cave cave, BearType bearType, double weight, LocalDate birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.cave = cave;
		this.bearType = bearType;
		this.weight = weight;
		this.birthdate = birthdate;
	}
	public Bear() {

	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "bearSequence")
	@SequenceGenerator(name="bearSequence", sequenceName="SQ_BEAR_PK", allocationSize=1)
	@Column(name="BEAR_ID")
	private int id;
	
	@Column(name="BEAR_NAME")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="CAVE_ID", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private Cave cave;
	
	@ManyToOne
	@JoinColumn(name="BEAR_TYPE_ID", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private BearType bearType;
	
	@Column(name="WEIGHT")
	private double weight;
	
	@Column(name="BIRTHDATE")
	private LocalDate birthdate;
	
	
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
	public Cave getCave() {
		return cave;
	}
	public void setCave(Cave cave) {
		this.cave = cave;
	}
	public BearType getBearType() {
		return bearType;
	}
	public void setBearType(BearType bearType) {
		this.bearType = bearType;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	@Override
	public String toString() {
		return "Bear [id=" + id + ", name=" + name + ", cave=" + cave + ", bearType=" + bearType + ", weight=" + weight
				+ ", birthdate=" + birthdate + "]";
	}


}
