package com.cgi.bootcamp.testing.basic;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.StringUtils;

public class EvenOddCheckerTest {
	
	@Test
	public void isEvenShouldReturnTrueForZero() {
		EvenOddChecker checker = new EvenOddChecker();
		
		//when
		boolean result = checker.isEven(0);
		
		//then
		Assert.assertTrue(result);
	}
	
	@Test
	public void isEvenShouldReturnFalseForOne() {
		EvenOddChecker checker = new EvenOddChecker();
		
		//when
		boolean result = checker.isEven(1);
		
		//then
		// TODO implement assertion
	}

	@Test
	public void isEvenShouldReturnTrueForTwo() {
		//TODO implement me
	}
	
	// TODO: implement some testcases for isOdd

}
