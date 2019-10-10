package com.cgi.bootcamp.testing.basic;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.StringUtils;

public class EvenOddCheckerTest {
	
	private EvenOddChecker checker = new EvenOddChecker();
	
	@Test
	public void isEvenShouldReturnTrueForZero() {
		//when
		boolean result = checker.isEven(0);
		
		//then
		Assert.assertTrue(result);
	}
	
	@Test
	public void isEvenShouldReturnFalseForOne() {
		//when
		boolean result = checker.isEven(1);
		
		//then
		Assert.assertFalse(result);
	}

	@Test
	public void isEvenShouldReturnTrueForTwo() {
		//when
		boolean result = checker.isEven(2);
		
		//then
		Assert.assertTrue(result);
	}
	
	@Test
	public void isOddShouldReturnTrueForOne() {
		//when
		boolean result = checker.isOdd(1);
		
		//then
		Assert.assertTrue(result);
	}

	@Test
	public void isOddShouldReturnFalseForTwo() {
		//when
		boolean result = checker.isOdd(2);
		
		//then
		Assert.assertFalse(result);
	}
}
