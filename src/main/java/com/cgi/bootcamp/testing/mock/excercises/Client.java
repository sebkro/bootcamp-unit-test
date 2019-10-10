package com.cgi.bootcamp.testing.mock.excercises;

import java.util.List;

//ACHTUNG: Keine Implementierung erforderlich
public interface Client {
	
	/**
	 * sende dem Client eine Message
	 * @param message message
	 */
	public void sendMessage(Message message);
	
	/**
	 * Gibt die Themen zurueck, an denen der Client interessiert ist
	 * @return Liste der Themen
	 */
	public List<String> getInterests();

}
