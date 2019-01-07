package com.revature.dao;

import java.util.List;

import com.revature.beans.Cave;

public interface CaveDAO {
	
	public Cave getCaveById(int id);
	public List<Cave> getAllCaves();
	public void addCave(Cave cave);
	public void updateCave(Cave cave);
	public void deleteCave(Cave cave);

}
