package com.cgi.bootcamp.testing.mock.excercises;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class MessageSenderTest {

	private MessageSender sender = new MessageSender();

	private Client client;
	private Message message;

	@Before
	public void init() {
		client = Mockito.mock(Client.class);
		message = Mockito.mock(Message.class);
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
		//given
		sender.registerClient(client);

		//when
		sender.sendMessage(message);

		//then
		verify(client).sendMessage(message);

	}

	/**
	 * - registriere mehrere Clients am MessageSender
	 * - sende eine Nachricht ohne topic
	 * - verifiziere, dass alle Clients die Nachricht bekommen haben
	 */
	@Test
	public void itShouldSendAMessageToMultipleSubscribedClients() {
		//given
		Client c2 = Mockito.mock(Client.class);
		Client c3 = Mockito.mock(Client.class);
		sender.registerClient(client);
		sender.registerClient(c2);
		sender.registerClient(c3);

		//when
		sender.sendMessage(message);

		//then
		verify(client).sendMessage(message);
		verify(c2).sendMessage(message);
		verify(c3).sendMessage(message);



	}

	/**
	 * Clients, die sich nicht registriert haben, sollen keine
	 * Nachrichten bekommen
	 */
	@Test
	public void itShouldNotSendMessagesToUnsubscribedClients() {
		//given dont register client

		//when
		sender.sendMessage(message);

		//then
		verify(client, never()).sendMessage(any(Message.class));
	}

	/**
	 * auch wenn ein Client sich mehrmals registriert soll er
	 * dieselbe Nachricht nur einmal bekommen
	 */
	@Test
	public void itShouldNotSendMessagesTwiceIfClientIsSubscribedTwice() {
		//given
		sender.registerClient(client);
		sender.registerClient(client);

		//when
		sender.sendMessage(message);

		//then
		verify(client).sendMessage(message);

	}

	/**
	 * Eine Message mit Topic soll nur an Clients ausgeliefert werden, die
	 * sich auf fuer dieses Topic interessieren
	 */
	@Test
	public void itShouldSendAMessageWithTopicOnlyToClientsInterestedInThisTopic() {
		//given
		List<String> interestsClient1 = new ArrayList<>();
		interestsClient1.add("Testen");
		interestsClient1.add("Java");
		when(client.getInterests()).thenReturn(interestsClient1);

		List<String> interestsClient2 = new ArrayList<>();
		interestsClient2.add("Angular");
		interestsClient2.add("Java");
		interestsClient2.add("Spring");
		Client client2 = Mockito.mock(Client.class);
		when(client2.getInterests()).thenReturn(interestsClient2);

		sender.registerClient(client);
		sender.registerClient(client2);

		Message message = Mockito.mock(Message.class);
		when(message.getTopic()).thenReturn("Testen");

		//when
		sender.sendMessage(message);

		//then
		verify(client).sendMessage(message);
		verify(client2, never()).sendMessage(message);

	}

}
