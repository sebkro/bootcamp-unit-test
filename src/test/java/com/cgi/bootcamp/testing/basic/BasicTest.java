package com.cgi.bootcamp.testing.basic;

import org.junit.Assert;
import org.junit.Test;


public class BasicTest {
	
	@Test
	public void javaShouldAdd() {
		//when
		int result = 1 + 1;
		
		//then
		Assert.assertEquals(2, result);
	}

}
