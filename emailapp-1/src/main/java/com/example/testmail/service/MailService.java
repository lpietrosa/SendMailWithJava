package com.example.testmail.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.testmail.model.User;

/*
 * Gestione della logica di business tramite oggetti di tipo Service
 * @Service funzione di elaborazione dati e che vengono forniti al Controller per essere esposti verso il client
 */

@Service
public class MailService {

	/*
	 * JavaMailSender estende l'interfaccia MailSender che contiente la funione send()
	 * E' richiesto l'oggetto SimpleMailMessage che il metodo send() userà un oggetto di tipo SimpleMailMessage come parametro
	 */
	
	private JavaMailSender javaMailSender;

	
	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	

	public void sendEmail(User user) throws MailException {


		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmailAddress());
		mail.setFrom("lukepetersaint@gmail.com");
		mail.setSubject("Testing Mail API");
		mail.setText("COPPA IN FACCIA!!!");

		
		javaMailSender.send(mail);
	}

	/*
	 * Metodo usato per inviare mail con allegato 
	 */
	
	
	
	public void sendEmailWithAttachment(User user) throws MailException, MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo(user.getEmailAddress());
		helper.setSubject("Testing Mail API with Attachment");
		helper.setText("Allegato in basso");

		FileSystemResource file = new FileSystemResource("");
		helper.addAttachment(file.getFilename(), file);

		javaMailSender.send(message);
	}

}
