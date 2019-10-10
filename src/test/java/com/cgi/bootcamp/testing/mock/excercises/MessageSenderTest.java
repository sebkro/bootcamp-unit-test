package com.cgi.bootcamp.testing.mock.excercises;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MessageSenderTest {
	
	private MessageSender sender = new MessageSender();
	
	private Client client;
	
	@Before
	public void init() {
	}
	
	/**
	 * - registriere genau einen Client am MessageSender
	 */
	@Test
	public void itShouldRegisterAClient() {
		//when
		int result = sender.registerClient(client);
		
		//then
		Assert.assertEquals(1, result);
				
				
	}

	/**
	 * - registriere genau einen Client am MessageSender
	 * - sende eine Nachricht ohne topic
	 * - verifiziere, dass der Client die Nachricht bekommen hat
	 */
	@Test
	public void itShouldSendAMessageToASingleSubscribedClient() {
		
	}

	/**
	 * - registriere mehrere Clients am MessageSender
	 * - sende eine Nachricht ohne topic
	 * - verifiziere, dass alle Clients die Nachricht bekommen haben
	 */
	@Test
	public void itShouldSendAMessageToMultipleSubscribedClients() {
		
	}

	/**
	 * Clients, die sich nicht registriert haben, sollen keine
	 * Nachrichten bekommen
	 */
	@Test
	public void itShouldNotSendMessagesToUnsubscribedClients() {
		
	}

	/**
	 * auch wenn ein Client sich mehrmals registriert soll er
	 * dieselbe Nachricht nur einmal bekommen
	 */
	@Test
	public void itShouldNotSendMessagesTwiceIfClientIsSubscribedTwice() {
		
	}
	
	/**
	 * Eine Message mit Topic soll nur an Clients ausgeliefert werden, die
	 * sich auf fuer dieses Topic interessieren
	 */
	@Test
	public void itShouldSendAMessageWithTopicOnlyToClientsInterestedInThisTopic() {
		
	}

}
