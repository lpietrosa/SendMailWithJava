package com.example.testmail.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testmail.model.User;
import com.example.testmail.service.MailService;


@RestController
public class MailController {

	@Autowired
	private MailService notificationService;

	@Autowired
	private User user;

	
	@RequestMapping("sendmail")
	public String send() {

		/*
		 *Creazione Utente che riceve la mail grazie alla classe User instanziata precedentemente
		 */
		user.setFirstName("luke");
		user.setLastName("petersaint");
		user.setEmailAddress("lukepetersaint@gmail.com");

		
		/*
		 * Chiamata del metodo sendEmail per l'invio della mail all'user dichiarato sopra
		 */

		try {
			notificationService.sendEmail(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulazioni la tua mail è stata inviata all'utente!";
	}

	
	@RequestMapping("sendmailattachment")
	public String sendWithAttachment() throws MessagingException {

		
		user.setFirstName("luke");
		user.setLastName("petersaint");
		user.setEmailAddress("lukepetersaint@gmail.com");

		try {
			notificationService.sendEmailWithAttachment(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulazioni la tua mail è stata inviata all'utente!";
	}
}