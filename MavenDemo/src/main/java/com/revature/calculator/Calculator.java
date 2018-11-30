package com.revature.calculator;

public class Calculator {

	public Calculator() {
	}

	public double add(String toAdd) {

		double sum = 0.0;
		if (!toAdd.equals("")) {

			// split the string toAdd on a , delimiter
			String[] numbers = toAdd.split(",");
			for (String number : numbers)

				// parse the values as doubles
				sum += Double.parseDouble(number);
		}
		// return their sum
		return sum;
	}

}
