package com.cgi.bootcamp.testing.mock;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.cgi.bootcamp.testing.basic.EvenOddChecker;

public class MyDependendClassTest {
	
	@Test
	public void itShouldReturnEvenForEvenNumber() {
		//given
		EvenOddChecker checker = new EvenOddChecker();
		MyDependendClass sut = new MyDependendClass(checker);
		
		//when
		String result = sut.produce(2);
		
		//then
		Assert.assertEquals("Even", result);
	}
	
	@Test
	public void itShouldReturnEvenForEvenNumberWithMock() {
		//given
		EvenOddChecker checker = Mockito.mock(EvenOddChecker.class);
		Mockito.when(checker.isEven(2)).thenReturn(true);
		
		MyDependendClass sut = new MyDependendClass(checker);
		
		//when
		String result = sut.produce(2);
		
		//then
		Assert.assertEquals("Even", result);
	}

	@Test
	public void itShouldReturnOddForOddNumberWithMock() {
		//given
		// TODO: Do the mocking 
		
		//when
		String result = sut.produce(1);
		
		//then
		Assert.assertEquals("Odd", result);
	}

}