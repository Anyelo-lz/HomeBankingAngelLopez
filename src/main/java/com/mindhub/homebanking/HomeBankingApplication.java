package com.mindhub.homebanking;

import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.models.Transaction;
import com.mindhub.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.repositories.ClientRepository;
import com.mindhub.homebanking.repositories.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static com.mindhub.homebanking.models.TransactionType.*;

@SpringBootApplication
public class HomeBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeBankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository, TransactionRepository transactionRepository){
		return args -> {

			Client melba = new Client("Melba","Morel","melba@mindhub.com");
			clientRepository.save(melba);

			Account accountMelba = new Account("VIN001", LocalDate.now(), 5000.00);
			melba.addAccount(accountMelba);
			accountRepository.save(accountMelba);

			Transaction buyAmazon = new Transaction(DEBIT, "He made a purchase at the Amazon Store for an Automatic Washing Machine.", LocalDateTime.now(),-300.00);
			accountMelba.addTransaction(buyAmazon);
			transactionRepository.save(buyAmazon);

			Transaction transfer = new Transaction(CREDIT, "Transfer of Julio Perez", LocalDateTime.now().plusDays(2),500.00);
			accountMelba.addTransaction(transfer);
			transactionRepository.save(transfer);

			Account accountMelba2 = new Account("VIN002", LocalDate.now().plusDays(1), 7500.00);
			melba.addAccount(accountMelba2);
			accountRepository.save(accountMelba2);

			Transaction OtherbuyAmazon = new Transaction(DEBIT, "Buy Notebook HP",LocalDateTime.now().plusDays(5),-3000.0);
			accountMelba2.addTransaction(OtherbuyAmazon);
			transactionRepository.save(OtherbuyAmazon);

			System.out.println(melba);


			Client Angel = new Client("Angel", "Lopez", "Angel@gmail.com");
			clientRepository.save(Angel);

			Account accountAngel = new Account("VIN003", LocalDate.now(), 7000.00);
			Angel.addAccount(accountAngel );
			accountRepository.save(accountAngel );

			Transaction buycoverall = new Transaction(DEBIT, "I bought a sweatshirt from the Adidas store", LocalDateTime.now().plusDays(1),-200.00);
			accountAngel .addTransaction(buycoverall);
			transactionRepository.save(buycoverall);

			Transaction brotherTransfer = new Transaction(CREDIT, "Transfer of Pedro Perez", LocalDateTime.now().plusDays(4),15000.00);
			accountAngel.addTransaction(brotherTransfer);
			transactionRepository.save(brotherTransfer);

			System.out.println(accountAngel);
		};
	}
}