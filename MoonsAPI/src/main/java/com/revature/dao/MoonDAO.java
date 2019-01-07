package com.revature.dao;

import java.util.List;

import com.revature.beans.Moon;

public interface MoonDAO {
	
	public List<Moon> getAllMoons();
	public Moon getMoonById(int id);
	

}
