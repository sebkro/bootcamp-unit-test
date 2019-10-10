package com.cgi.bootcamp.testing.mock.excercises;

import java.util.HashSet;
import java.util.Set;

public class MessageSender {
	
	private Set<Client> clients = new HashSet<>();
	
	/**
	 * Registriert einen Client
	 * @param client der zu registrierende client
	 * @return Anzahl der registrierten clients nach Hinzufuegen des neuen clients
	 */
	public int registerClient(Client client) {
		clients.add(client);
		return clients.size();
	}
	
	/**
	 * sendet eine Nachricht an die registrierten Clients
	 * @param message Nachricht die versendet werden soll
	 */
	public void sendMessage(Message message) {
		if (message.getTopic() == null) {
			clients.forEach(client -> client.sendMessage(message));
		} else {
			clients.stream()
				.filter(c -> c.getInterests().contains(message.getTopic()))
				.forEach(client -> client.sendMessage(message));
		}
	}

}
