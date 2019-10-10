package com.cgi.bootcamp.testing.basic;

public class EvenOddChecker {
	
	public boolean isEven(int number) {
		return number % 2 == 0;
	}

	public boolean isOdd(int number) {
		return !isEven(number);
	}

}
