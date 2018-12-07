package com.revature.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.transport.Car;

public class SerializeAndODemo {

	public static void main(String[] args) {
		
		String filename = "src/SerializedThings.txt";
		List<Car> carList = new ArrayList<Car>();
		carList.add(new Car(2021,"spaceship","Tesla",50));
		carList.add(new Car(2018,"Escalade","Cadillac",50));
		carList.add(new Car(2005,"350Z","Nissan",50));
		for (Car c : carList) {
			System.out.println(c);
		}
		serializeToFile(filename,carList);
		
		
	}
	
	
	//serialize an object and write it to a file
	static void serializeToFile(String filename, Object o) {
		try {
			//use a FileOutputStream to write serialized object to file
			FileOutputStream fileOut = new FileOutputStream(filename);
			//use ObjectOutputStream to serialize the object
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(o); //what actually does the serialization
			//close resources
			out.close();
			fileOut.close();
			
		} catch(FileNotFoundException f) {
			f.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static Object deserializedFromFile(String filename) {
		Object o = null;
		try {
			FileInputStream fileIn = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(fileIn);
		}catch (FileNotFoundException f) {
			f.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return filename;
		
	}
	
	
	
	
	
	
	
	
	
}
