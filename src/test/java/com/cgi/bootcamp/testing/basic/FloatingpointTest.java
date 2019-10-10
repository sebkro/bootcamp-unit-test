package com.cgi.bootcamp.testing.basic;

import org.junit.Assert;
import org.junit.Test;

public class FloatingpointTest {
	
	@Test
	public void itShouldDoSimpleMath() {
		//when
		double result = (0.01 * 100) / 100;
		
		//then
		Assert.assertEquals(result, 0.01, 0.001);
	}

}
