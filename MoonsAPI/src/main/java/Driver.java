import java.util.List;

import com.revature.beans.Moon;
import com.revature.beans.Planet;
import com.revature.dao.MoonDAO;
import com.revature.dao.MoonDAOImpl;
import com.revature.service.SpaceService;

public class Driver {
	

	public static void main(String[] args) {
		MoonDAO md = new MoonDAOImpl();
		SpaceService ss = new SpaceService();
		List<Planet> planets = ss.getAllPlanets();
		for (Planet p : planets) {
			System.out.println(p);
		}
		
		List<Moon> moons = md.getAllMoons();
		for (Moon m : moons) {
			System.out.println(m);
		}
		
		System.out.println(ss.getPlanetById(1000));
		System.out.println(md.getMoonById(1006));

	}

}
