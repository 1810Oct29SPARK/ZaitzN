package com.revature.example;

public class ControlFlow {

	public static void main(String[] args) {

		ifStatements(7.5, 7.5);
		forLoops();
		whileLoops();
		switchCases();
	}

	static void ifStatements(double a, double b) {

		// can have as many else-ifs as you want
		if (a > b) {
			System.out.println("a is greater than b");
		} else if (a == b) {
			System.out.println("a equals b");
		} else {
			System.out.println("a is less than b");
		}

	}

	static void forLoops() {

		// simple for loop
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		// does nothing forever
		/*
		 * for(;;) {
		 * 
		 * }
		 */
		/*
		 * break and continue "break" = exits the structure (terminates for, while, or
		 * do-while) "continue" = goes to the next iteration
		 */

		for (int j = 0;; j++) {

			if (j % 2 != 0) {
				continue;
			}
			System.out.println(j);
			if (j == 20) {
				break;
			}
		}

	}

	static void whileLoops() {
		// this is infinite. using a break statement to make it finite.
		int i = 0;
		while (true) {
			System.out.println(i);
			i += 1;
			if (i > 150) {
				break;
			}
		}

		do {
			System.out.println("do block always runs before condition");
		} while (false);

	}

	static void switchCases() {
		/*
		 * switch statement allows us to execute different behavior based on an
		 * expression can be byte, short, char, int, Enum, String, wrapper class
		 */
		DaysOfTheWeek dayOfWeek = DaysOfTheWeek.TUESDAY;
		switch (dayOfWeek) {

		case SUNDAY:
			System.out.println("Today is Sunday");
			break;

		case MONDAY:
			System.out.println("Today is Monday");
			break;
			
		case TUESDAY:
			System.out.println("Today is Tuesday");
			break;
			
		case WEDNESDAY:
			System.out.println("Today is Wednesday");
			break;
			
		case THURSDAY:
			System.out.println("Today is Thursday");
			break;
			
		case FRIDAY:
			System.out.println("Today is Friday");
			break;
			
		case SATURDAY: 
			System.out.println("Today is Saturday");
			break;
			
		default:
			System.out.println("Today is nothing");
			
		}

	}
}
