package com.mch.contactmanagement;

import com.mch.contactmanagement.entities.Contact;
import com.mch.contactmanagement.service.ContactService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ContactManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactManagementApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ContactService contactService){
		return args -> {
			contactService.saveContact(Contact.builder().firstName("Chebbi").lastName("Marwane").address("66 rue du tir").city("Maisons Laffitte").postalCode("78600").build());
			contactService.saveContact(Contact.builder().firstName("Toto").lastName("Tata").address("66 rue du tir").city("Paris").postalCode("75001").build());
			contactService.saveContact(Contact.builder().firstName("Test").lastName("testPrenom").address("avenue du général de gaulle").city("Sartrouville").postalCode("78200").build());
			contactService.saveContact(Contact.builder().firstName("first").lastName("Last").address("66 rue du chat").city("Maisons Laffitte").postalCode("78500").mail("test@test.fr").build());
		};
	}

}
