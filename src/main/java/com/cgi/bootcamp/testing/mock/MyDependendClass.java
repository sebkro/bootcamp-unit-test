package com.cgi.bootcamp.testing.mock;

import com.cgi.bootcamp.testing.basic.EvenOddChecker;

public class MyDependendClass {
	
	private EvenOddChecker evenOddChecker;
	
	public MyDependendClass(EvenOddChecker eventOddChecker) {
		this.evenOddChecker = eventOddChecker;
	}
	
	public String produce(int i) {
		return evenOddChecker.isEven(i) ? "Even" : "Odd"; 
	}

}
