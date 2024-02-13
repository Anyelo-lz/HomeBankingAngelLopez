package com.mindhub.homebanking;

import com.mindhub.homebanking.models.*;
import com.mindhub.homebanking.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static com.mindhub.homebanking.models.TransactionType.*;

@SpringBootApplication
public class HomeBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeBankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository, TransactionRepository transactionRepository, LoanRepository loanRepository, ClientLoanRepository clientLoanRepository){
		return args -> {




			Client melba = new Client("Melba", "Morel", "melba@mindhub.com");
			clientRepository.save(melba);

			Client git angel =new Client("Angel","Lopez","angelwilliamleonel@gmail.com");
            clientRepository.save(angel);


			Account accountMelba = new Account("VIN001", LocalDate.now(), 5000.00);
			melba.addAccount(accountMelba);
			accountRepository.save(accountMelba);


			Account accountMelba2 = new Account("VIN002", LocalDate.now().plusDays(1), 7500.00);
			melba.addAccount(accountMelba2);
			accountRepository.save(accountMelba2);


			Account accountAngel = new Account("VIN003", LocalDate.now(), 6000.00);
			angel.addAccount(accountAngel);
			accountRepository.save(accountAngel);


			Account accountAngel2 = new Account("VIN004",LocalDate.now().plusDays(2),7000.00);
			angel.addAccount(accountAngel2);
			accountRepository.save(accountAngel2);



			Transaction buyAmazon = new Transaction(DEBIT, "He made a purchase at the Amazon Store for an Automatic Washing Machine.", LocalDateTime.now(), -300.00);
			accountMelba.addTransaction(buyAmazon);
			transactionRepository.save(buyAmazon);


			Transaction transfer = new Transaction(CREDIT, "Transfer of Julio Perez", LocalDateTime.now().plusDays(2), 500.00);
			accountMelba.addTransaction(transfer);
			transactionRepository.save(transfer);

			Transaction otherBuyAmazon = new Transaction(DEBIT, "Buy Notebook HP", LocalDateTime.now().plusDays(4), -3000.0);
			accountMelba2.addTransaction(otherBuyAmazon);
			transactionRepository.save(otherBuyAmazon);



			Loan mortgage = new Loan("Hipoteca", 500000.00, Arrays.asList(12, 24, 36, 48, 60));
			loanRepository.save(mortgage);

			Loan personal = new Loan("Personal", 100000.00, Arrays.asList(6, 12, 24));
			loanRepository.save(personal);

			Loan automotive  = new Loan("Automotive",300000.00, Arrays.asList(6,12,24,36));
            loanRepository.save(automotive);



			ClientLoan melbaMortgage = new ClientLoan(melba, mortgage, 400000.00, 60);
			melba.addClientLoan(melbaMortgage);
			clientRepository.save(melba);

			ClientLoan melbaPersonal = new ClientLoan(melba, personal, 50000.00, 12);
			melba.addClientLoan(melbaPersonal);
			clientRepository.save(melba);

			ClientLoan melbaAutomotive =new ClientLoan(melba,automotive,300000.00,36);
			angel.addClientLoan(melbaAutomotive);
			clientRepository.save(melba);


			ClientLoan angelPersonal=new ClientLoan(angel,personal,100000.00,24);
			angel.addClientLoan(angelPersonal);
			clientRepository.save(angel);

			ClientLoan angelAutomotive =new ClientLoan(angel,automotive,200000.00,36);
			angel.addClientLoan(angelAutomotive);
			clientRepository.save(angel);

			clientLoanRepository.save(melbaMortgage);
			clientLoanRepository.save(melbaPersonal);
			clientLoanRepository.save(melbaAutomotive);

			clientLoanRepository.save(angelPersonal);
			clientLoanRepository.save(angelAutomotive);

		};
	}
}