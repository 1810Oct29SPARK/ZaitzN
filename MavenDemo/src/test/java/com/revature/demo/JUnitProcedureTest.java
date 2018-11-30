package com.revature.demo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class JUnitProcedureTest {
	
	@BeforeClass
	public static void beforeAllTests() {
		System.out.println("in beforeAllTests");
	}
	
	@AfterClass
	public static void afterAllTests() {
		System.out.println("in afterAllTests");
	}
	
	@Before
	public void beforeTests() {
		System.out.println("in beforeTests");
	}
	
	@Test
	public void testCase1() {
		System.out.println("in testCase1");
	}
	
	@Test
	public void testCase2() {
		System.out.println("in testCase2");
	}

	@After
	public void afterTests() {
		System.out.println("in afterTests");
	}

	
}
