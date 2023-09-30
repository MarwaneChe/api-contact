package com.mch.contactmanagement;

import com.mch.contactmanagement.entities.Contact;
import com.mch.contactmanagement.service.ContactService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@SpringBootApplication
public class ContactManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactManagementApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ContactService contactService){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE);
		return args -> {
			contactService.saveContact(Contact.builder().firstName("Chebbi").lastName("Marwane").mobile("0606062314").address("26 rue Gabrielle")
					.additionalAddress("Batiment 2").city("Gentilly").postalCode("94200").mail("test@mail.com").dateOfBirth(formatter.parse("2000-09-30"))
					.creationDate(formatter.parse("2023-09-30")).updateDate(formatter.parse("2023-09-30")).build());
			contactService.saveContact(Contact.builder().firstName("Cheb").lastName("Marwen").mobile("0606067414").address("16 rue Général")
					.additionalAddress("Batiment 8").city("Paris").postalCode("75003").mail("test2@mail.com").dateOfBirth(formatter.parse("1997-09-30"))
					.creationDate(formatter.parse("2023-09-30")).updateDate(formatter.parse("2023-09-30")).build());
			contactService.saveContact(Contact.builder().firstName("Bartez").lastName("Fabien").mobile("0606542314").address("26 rue de la defense")
					.additionalAddress("Batiment 7").city("Paris").postalCode("75008").mail("test2@mail.com").dateOfBirth(formatter.parse("1990-09-15"))
					.creationDate(formatter.parse("2023-09-30")).updateDate(formatter.parse("2023-09-30")).build());
			contactService.saveContact(Contact.builder().firstName("Zidane").lastName("Zidane").mobile("0606067114").address("26 rue la bievre")
					.additionalAddress("Batiment 10").city("Paris").postalCode("75009").mail("test4@mail.com").dateOfBirth(formatter.parse("1989-09-25"))
					.creationDate(formatter.parse("2023-09-30")).updateDate(formatter.parse("2023-09-30")).build());
		};
	}

}
