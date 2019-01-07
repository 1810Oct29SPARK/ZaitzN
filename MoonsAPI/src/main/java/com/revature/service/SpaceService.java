package com.revature.service;

import java.util.List;

import com.revature.beans.Moon;
import com.revature.beans.Planet;
import com.revature.dao.MoonDAO;
import com.revature.dao.MoonDAOImpl;
import com.revature.dao.PlanetDAO;
import com.revature.dao.PlanetDAOImpl;

public class SpaceService {
	
	
	MoonDAO md = new MoonDAOImpl();
	PlanetDAO pd = new PlanetDAOImpl();


	public List<Moon> getAllMoons() {
		
		List<Moon> ml = md.getAllMoons();
		return ml;
		
	}

	
	public Moon getMoonById(int id) {
		Moon moon = md.getMoonById(id);
		return moon;
	}

	
	public void updateMoonById(int id) {
		// TODO Auto-generated method stub
		
	}

	
	public void deleteMoonById(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
	public List<Planet> getAllPlanets() {
		List<Planet> pl = pd.getAllPlanets();
		return pl;
	}

	
	public Planet getPlanetById(int id) {
		Planet planet = pd.getPlanetById(id);
		return planet;
	}

	
	public void updatePlanetById(int id) {
		// TODO Auto-generated method stub
		
	}

	
	public void deletePlanetById(int id) {
		// TODO Auto-generated method stub
		
	}


}
