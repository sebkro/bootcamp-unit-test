package com.cgi.bootcamp.testing.basic;

import org.junit.Assert;
import org.junit.Test;

public class StringTest {
	
	@Test
	public void itShouldConvertAllLowercaseStringToUppercase() {
		//when
		String result = "abcd".toUpperCase();
		
		//then
		//TODO: Fix test
		Assert.assertEquals("ABCd", result);
	}
	
	
	// TODO: Test 2 : Pruefe das "abCd".toUpperCase() "ABCD" ergibt 
	// TODO: Test 3 : Pruefe das "ABCD".toUpperCase() "ABCD" ergibt 

}
