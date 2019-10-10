package com.cgi.bootcamp.testing.mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
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
import org.mockito.Mockito;

public class MockTest {

	private static final ZoneId ZONE_BERLIN = ZoneId.of("Europe/Berlin");
	private static final ZoneId ZONE_LA = ZoneId.of("America/Los_Angeles");
	private static final ZoneId ZONE_CHICAGO = ZoneId.of("America/Chicago");

	private Timeprovider timeProvider;
	private ArgumentCaptor<ZoneId> argumentCaptor;

	@Before
	public void init() {
		timeProvider = Mockito.mock(Timeprovider.class);
		argumentCaptor = ArgumentCaptor.forClass(ZoneId.class);
	}

	@Test
	public void timeProviderShouldBeInstanceOfTimeprovider() {
		Assert.assertTrue(timeProvider instanceof Timeprovider);
	}

	@Test
	public void timeProviderShouldReturnDayOfWeek() {
		//given
		ZonedDateTime time = ZonedDateTime.of(LocalDateTime.of(2018, 2, 20, 15, 34, 31), ZONE_BERLIN);
		when(timeProvider.now()).thenReturn(time);

		//when
		ZonedDateTime result = timeProvider.now();

		//then
		Assert.assertEquals(time, result);
	}

	@Test
	public void timeProviderShouldReturnDayOfWeekWithZone() {
		//given
		ZonedDateTime timeBerlin = ZonedDateTime.of(LocalDateTime.of(2018, 2, 20, 15, 34, 31), ZONE_BERLIN);
		ZonedDateTime timeLA = ZonedDateTime.of(LocalDateTime.of(2018, 2, 20, 15, 34, 31), ZONE_LA);
		when(timeProvider.nowIn(ZONE_BERLIN)).thenReturn(timeBerlin);
		when(timeProvider.nowIn(ZONE_LA)).thenReturn(timeLA);

		//when
		ZonedDateTime resultBerlin = timeProvider.nowIn(ZONE_BERLIN);
		ZonedDateTime resultLA = timeProvider.nowIn(ZONE_LA);
		ZonedDateTime resultChicago = timeProvider.nowIn(ZONE_CHICAGO);

		//then
		Assert.assertEquals(timeBerlin, resultBerlin);
		Assert.assertEquals(timeLA, resultLA);
		Assert.assertEquals(null, resultChicago);
	}

	@Test
	public void timeProviderMatcherEq() {
		//given
		ZonedDateTime time = ZonedDateTime.of(LocalDateTime.of(2018, 2, 20, 15, 34, 31), ZONE_BERLIN);
		when(timeProvider.nowIn(eq(ZONE_BERLIN))).thenReturn(time);

		//when
		ZonedDateTime resultBerlin = timeProvider.nowIn(ZONE_BERLIN);
		ZonedDateTime resultChicago = timeProvider.nowIn(ZONE_CHICAGO);

		//then
		Assert.assertEquals(time, resultBerlin);
		Assert.assertEquals(null, resultChicago);
	}

	@Test
	public void timeProviderMatcherAny() {
		//given
		ZonedDateTime time = ZonedDateTime.of(LocalDateTime.of(2018, 2, 20, 15, 34, 31), ZONE_BERLIN);
		when(timeProvider.nowIn(any(ZoneId.class))).thenReturn(time);

		//when
		ZonedDateTime resultBerlin = timeProvider.nowIn(ZONE_BERLIN);
		ZonedDateTime resultChicago = timeProvider.nowIn(ZONE_CHICAGO);

		//then
		Assert.assertEquals(time, resultBerlin);
		Assert.assertEquals(time, resultChicago);
	}

	@Test
	public void timeProviderMatcherAnystring() {
		//given
		ZonedDateTime time = ZonedDateTime.of(LocalDateTime.of(2018, 2, 20, 15, 34, 31), ZONE_BERLIN);
		when(timeProvider.nowIn(any(String.class))).thenReturn(time);

		//when
		ZonedDateTime result = timeProvider.nowIn("blabla");

		//then
		Assert.assertEquals(time, result);
	}

	@Test
	public void timeProviderMatcherAnystring2() {
		//given
		ZonedDateTime time = ZonedDateTime.of(LocalDateTime.of(2018, 2, 20, 15, 34, 31), ZONE_BERLIN);
		when(timeProvider.nowIn(anyString())).thenReturn(time);

		//when
		ZonedDateTime result = timeProvider.nowIn("blabla");

		//then
		Assert.assertEquals(time, result);
	}

	@Test
	public void timeProviderVerify() {
		//given
		ZonedDateTime time = ZonedDateTime.of(LocalDateTime.of(2018, 2, 20, 15, 34, 31), ZONE_BERLIN);
		when(timeProvider.now()).thenReturn(time);

		//when
		ZonedDateTime result = timeProvider.now();

		//then
		Assert.assertEquals(time, result);
		verify(timeProvider).now();
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
			result.add(timeProvider.now());
		}

		//then
		List<ZonedDateTime> expected = new ArrayList<>();
		expected.add(time1);
		expected.add(time2);
		expected.add(time3);

		Assert.assertEquals(expected, result);
		verify(timeProvider, times(3)).now();
	}

	@Test
	public void timeProviderVerifyWithArgument() {
		//given
		ZonedDateTime time = ZonedDateTime.of(LocalDateTime.of(2018, 2, 20, 15, 34, 31), ZONE_BERLIN);
		when(timeProvider.nowIn(any(ZoneId.class))).thenReturn(time);

		//when
		ZonedDateTime result = timeProvider.nowIn(ZONE_BERLIN);

		//then
		Assert.assertEquals(time, result);
		verify(timeProvider).nowIn(ZONE_BERLIN);
	}

	@Test
	public void timeProviderVerifyWithArgumentCaptor() {
		//given
		ZonedDateTime time = ZonedDateTime.of(LocalDateTime.of(2018, 2, 20, 15, 34, 31), ZONE_BERLIN);
		when(timeProvider.nowIn(any(ZoneId.class))).thenReturn(time);

		//when
		ZonedDateTime result = timeProvider.nowIn(ZONE_BERLIN);

		//then
		Assert.assertEquals(time, result);
		verify(timeProvider).nowIn(argumentCaptor.capture());

		Assert.assertEquals(ZONE_BERLIN, argumentCaptor.getValue());
	}


}
