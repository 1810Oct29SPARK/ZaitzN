package com.revature.example;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorDemo {

	public static void main(String[] args) {
		ArrayList<Integer> exampleList = new ArrayList<Integer>();
		exampleList.add(6);
		exampleList.add(15);
		exampleList.add(49);
		exampleList.add(61);
		exampleList.add(72);
		exampleList.add(90);
		
		Iterator<Integer> i = exampleList.iterator();
		
		//move through the list using .hasNext()
		
		while (i.hasNext()) {
			//System.out.println(i.next());
			if(i.next()%2 !=0) {
				i.remove();
			}
		}
		System.out.println(exampleList);
	}

}
