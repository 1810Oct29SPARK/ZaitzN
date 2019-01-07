package com.revature.dao;

import java.util.List;

import com.revature.beans.Planet;

public interface PlanetDAO {

	public List<Planet> getAllPlanets();
	public Planet getPlanetById(int id);

	
}
