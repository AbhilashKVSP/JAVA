package com.Java.Myjunit;

public class MyMath {

	public int calculateSum(int[] numbers) {
		int sum = 0;
		for (int number : numbers) {
			sum += number;
		}
		return sum;
	}
}
