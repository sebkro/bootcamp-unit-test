package com.cgi.bootcamp.testing.basic;

import org.junit.Assert;
import org.junit.Test;

public class StringTest {
	
	@Test
	public void itShouldConvertAllLowercaseStringToUppercase() {
		//when
		String result = "abcd".toUpperCase();
		
		//then
		Assert.assertEquals("ABCD", result);
	}

	@Test
	public void itShouldConvertStringWithUpperCaseLettersToUppercase() {
		//when
		String result = "abCd".toUpperCase();
		
		//then
		Assert.assertEquals("ABCD", result);
	}

	@Test
	public void itShouldConvertUppercaseStringToUppercase() {
		//when
		String result = "ABCD".toUpperCase();
		
		//then
		Assert.assertEquals("ABCD", result);
	}
	
}
