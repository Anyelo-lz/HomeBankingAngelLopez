package com.mindhub.homebanking;

import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository){
		return args -> {

			Client melba = new Client("Melba","Morel","Morel@mindhub.com");
			clientRepository.save(melba);
			Account accountMelba = new Account("VIN001", LocalDate.now(), 5000.00, melba);
			melba.addAccount(accountMelba);
			accountRepository.save(accountMelba);
			Account accountMelba2 = new Account("VIN002", LocalDate.now().plusDays(1), 7500.00, melba);
			melba.addAccount(accountMelba2);
			accountRepository.save(accountMelba2);


			System.out.println(melba);

			Client miCuenta = new Client("Angel", "Lopez", "Angel@gmail.com");
			clientRepository.save(miCuenta);
			Account accountMiCuenta = new Account("VIN003", LocalDate.now(), 7000.00, miCuenta);
			miCuenta.addAccount(accountMiCuenta);
			accountRepository.save(accountMiCuenta);
			Account accountMiCuenta2  = new Account("VIN004", LocalDate.now().plusDays(1), 500.00,miCuenta);
			miCuenta.addAccount(accountMiCuenta2);
			accountRepository.save(accountMiCuenta2);

			System.out.println(miCuenta);

			Client otraCuenta = new Client("Evelyn", "Farias", "Eve@gmail.com");
			clientRepository.save(otraCuenta);
			Account accountotraCuenta = new Account("VIN005", LocalDate.now(), 7000.00, otraCuenta);
			otraCuenta.addAccount(accountotraCuenta);
			accountRepository.save(accountotraCuenta);
			Account accountYo2  = new Account("VIN006", LocalDate.now().plusDays(1), 500.00,otraCuenta);
			otraCuenta.addAccount(accountYo2);
			accountRepository.save(accountYo2);
			System.out.println(otraCuenta);
		};
	}
}