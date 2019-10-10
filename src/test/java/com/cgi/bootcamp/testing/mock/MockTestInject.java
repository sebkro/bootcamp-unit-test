package com.cgi.bootcamp.testing.mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MockTestInject {
	
	private static final ZoneId ZONE_BERLIN = ZoneId.of("Europe/Berlin");
	
	@InjectMocks
	private TimeproviderWrapper wrapper = new TimeproviderWrapper();
	
	@Mock
	private Timeprovider timeProvider;
	
	@Captor
	private ArgumentCaptor<ZoneId> argumentCaptor;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void timeProviderShouldReturnDayOfWeek() {
		//given
		ZonedDateTime time = ZonedDateTime.of(LocalDateTime.of(2018, 2, 20, 15, 34, 31), ZONE_BERLIN);
		when(timeProvider.now()).thenReturn(time);
		
		//when
		ZonedDateTime result = wrapper.now();
		
		//then
		Assert.assertEquals(time, result);
	}

	@Test
	public void timeProviderVerifyTimes() {
		//given
		ZonedDateTime time1 = ZonedDateTime.of(LocalDateTime.of(2018, 2, 20, 15, 34, 31), ZONE_BERLIN);
		ZonedDateTime time2 = ZonedDateTime.of(LocalDateTime.of(2018, 2, 20, 16, 34, 31), ZONE_BERLIN);
		ZonedDateTime time3 = ZonedDateTime.of(LocalDateTime.of(2018, 2, 20, 17, 34, 31), ZONE_BERLIN);
		
		when(timeProvider.now()).thenReturn(time1, time2, time3);
		
		//when
		List<ZonedDateTime> result = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			result.add(wrapper.now());
		}
		
		//then
		List<ZonedDateTime> expected = new ArrayList<>();
		expected.add(time1);
		expected.add(time2);
		expected.add(time3);
		
		Assert.assertEquals(expected, result);
		verify(timeProvider, times(3)).now();
	}
	
}
