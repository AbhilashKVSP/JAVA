package com.Java.Myjunit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyAssertTest {

	List<String> todos = Arrays.asList("AWS","Azure","Devops");
	
	@Test
	void todoTest() {
		boolean test = todos.contains("AWS");
		boolean test2 = todos.contains("ACP");

		assertEquals(true,test);
		assertEquals(3,todos.size());
		assertFalse(test2);
		
		assertArrayEquals(new int[] {1,2}, new int[] {1,2});
		
	}

}
