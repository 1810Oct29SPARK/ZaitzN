package com.revature.vacation;

import com.revature.transport.*; //.* imports all classes in the package
//to get a specific class, use class name instead of * to get all classes in the package

//static imports within a class
import static com.revature.transport.Car.*;

import java.util.Arrays;
import java.util.*;

public class GoOnVacation {

	public static void main(String[] args) {

		System.out.println("let's go to Miami");
		System.out.println("we need a car");
		// using fully qualified class name of Car (package.classname)
		// com.revature.transport.Car c = new com.revature.transport.Car();
		// or we could use imports.... save us typing!!!
		Car c = new Car(2021, "spaceship", "Tesla", 50);
		System.out.println(c);// prints out whatever toString() returns, same as using c.toString()
		System.out.println("do we need to change the oil first?");
		System.out.println("recommended miles between oil changes: " + Car.recommendedMilesBetweenOilChanges);
		if (c.getMilesSinceOilChange() >= recommendedMilesBetweenOilChanges) {
			System.out.println("Stop! Change your oil!");
		} else {
			System.out.println("good to go");
		}
		System.out.println("made it to Miami, let's go kayaking");
		Kayak k = new Kayak("red",4.2,2,2);
		System.out.println(k.getColor());//inherited from superclass
		System.out.println(k);
		Vehicle[] garage = {new Tornado(147.2), new Kayak("red",4.2,2,2), new Car(2021,"spaceship","Tesla",50), new Tornado(5000)};
		System.out.println(chooseAVehicle(garage));
		//fun with final
		//Car.recommendedMilesBetweenOilChanges = 4000; // no good! cannot be reassigned when made final
		System.out.println();
		System.out.println(Arrays.toString(Arrays.copyOf(doubleArray, 5)));
		System.out.println(Arrays.spliterator(doubleArray));
		System.out.println(Arrays.hashCode(doubleArray));

	}
	
	public static double[] doubleArray = {4.5,5.5,6.5,7.5,8.5};
	
	static Vehicle chooseAVehicle(Vehicle[] garage) {
		Vehicle chosenVehicle = null;
		//check for steerable vehicles that are not boats, choose first one
		for (int i = 0; i < garage.length; i++) {
			if (garage[i] instanceof Steerable && !(garage[i] instanceof Boat)) {
				chosenVehicle = garage[i];
				return chosenVehicle;
			}
		}
		
		return chosenVehicle;
	}

}
