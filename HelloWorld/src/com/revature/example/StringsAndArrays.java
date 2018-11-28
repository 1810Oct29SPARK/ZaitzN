package com.revature.example;

import java.util.Arrays;

public class StringsAndArrays {

	public static void main(String[] args) {
		funWithStrings();
		funWithArrays();
	}
	
	static void funWithArrays() {
		String[] arr1 = {"this","is","an","array"};
		String[] arr2 = new String[4];
		for(int i=0;i<arr2.length;i++) {
			arr2[i] = "element "+i;
		}
		System.out.println(Arrays.toString(arr2));
	}
	
	static void funWithStrings() {
		
		String a = "hello";
		String b = new String("hello");
		
		/*
		 * .equals() is inherited from Object
		 * most reference types override this to define "equality"
		 * (usually by the fields)
		 * String has it overridden to check the string literal
		 */

		System.out.println("string a is equal to string b: "+a.equals(b));
		
		/*
		 *  == is good for comparing primitives or checking whether two objects are the same object
		 *  (compare the REFERENCE)
		 */
		
		System.out.println("string a is the same object as string b: "+(a == b));
		
		//a and b are two separate objects pointing to the same literal in the string pool
		
		/*
		 * String API methods
		 * substring
		 * concat
		 * toUpperCast
		 * toLowerCase
		 * replace
		 * indexOf
		 * split
		 * trim
		 * ... and many more
		 */
		
		String test1 = "hello world";
		System.out.println(test1.toUpperCase());
		String test2 = "HELLO WORLD";
		System.out.println(test2.toLowerCase());
		System.out.println(test1.substring(3,8));
		System.out.println(test1.concat(test2));
		System.out.println(test1.replace('l','p'));
		System.out.println(test1.indexOf('l'));
		String test3 = "the.quick.brown.fox.jumped.over.the.lazy.dog";
		System.out.println(test3.split("."));
	}

}
