package com.Java.Myjunit;

import org.junit.jupiter.api.*;

class MyBeforeAfter {

	@BeforeAll
	static void beforeAll() {
		System.out.println("before All..");
	}
	
	@BeforeEach
	void test0() {
		System.out.println("Before Each..");
	}
	
	@Test
	void test1() {
		System.out.println("test1");
	}
	
	@Test
	void test2() {
		System.out.println("test2");
	}
	
	@Test
	void test3() {
		System.out.println("test3");
	}
	
	@AfterAll
	static void AfterAll() {
		System.out.println("After All..");
	}

}
