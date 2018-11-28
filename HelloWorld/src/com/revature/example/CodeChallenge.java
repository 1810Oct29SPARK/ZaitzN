package com.revature.example;

public class CodeChallenge {

	public CodeChallenge() {

	}

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 *
	 * @param string
	 * @return
	 */
	public String reverse(String string) {

		String reversed = "";

		for (int i = string.length() - 1; i >= 0; i--) {
			reversed = reversed + string.charAt(i);

		}

		return reversed;
	}

	public String reverse2(String string2) {

		String reversed = "";
		char[] test = string2.toCharArray();
		for (int i = test.length - 1; i >= 0; i--) {
			reversed = reversed + test[i];
		}

		return reversed;
	}

	public static void main(String[] args) {
		CodeChallenge a = new CodeChallenge();
		System.out.println(a.reverse("Supercalifragilisticexpialidocious"));
		System.out.println(a.reverse2("Supercalifragilisticexpialidocious "));

	}
}
