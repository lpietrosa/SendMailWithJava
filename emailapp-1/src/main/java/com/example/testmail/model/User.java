package com.example.testmail.model;

import org.springframework.stereotype.Component;

/*
 * Classe marcata come componente.
 * All'avvio dell'applicazione tutte le classi annotate come @Component verranno instanziate e registrare nell'ApplicationContext
 * 
 * 
 */

@Component
public class User {

	private String firstName;
	private String lastName;
	private String emailAddress;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
