package com.revature.example;

import java.util.LinkedList;
import java.util.Spliterator;

public class TestLinkedLists {

	public static void main(String[] args) {
		LinkedList<String> wordList = new LinkedList<String>();
		wordList.add("Second");
		wordList.push("First");
		wordList.push("Third");
		wordList.pop();
		wordList.addLast("Third");
		wordList.offerLast("Fourth");
		System.out.println(wordList.size());
		System.out.println(wordList);
		
		Spliterator<String> testyTest = wordList.spliterator();
		System.out.println("Elements in order");
		
		testyTest.forEachRemaining((n) -> System.out.println("This one is "+n));
	}

}

/*
 * 
 * 
 */
