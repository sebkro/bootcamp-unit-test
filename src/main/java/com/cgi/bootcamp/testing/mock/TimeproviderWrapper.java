package com.cgi.bootcamp.testing.mock;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;

public class TimeproviderWrapper {
	
	@Autowired
	private Timeprovider timeProvider;
	
	public ZonedDateTime now() {
		return timeProvider.now();
	}
	
	public ZonedDateTime nowIn(ZoneId zoneId) {
		return timeProvider.nowIn(zoneId);
	}

	public ZonedDateTime nowIn(String zoneId) {
		return timeProvider.nowIn(zoneId);
	}

}
