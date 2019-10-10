package com.cgi.bootcamp.testing.mock;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Timeprovider {
	
	public ZonedDateTime now() {
		return ZonedDateTime.now();
	}
	
	public ZonedDateTime nowIn(ZoneId zoneId) {
		return ZonedDateTime.now(zoneId);
	}

	public ZonedDateTime nowIn(String zoneId) {
		return ZonedDateTime.now(ZoneId.of(zoneId));
	}

}
