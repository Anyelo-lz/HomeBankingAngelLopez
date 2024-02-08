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

			Client angel =new Client("Angel","Lopez","angelwilliamleonel@gmail.com");
            clientRepository.save(angel);


			Account accountMelba = new Account("VIN001", LocalDate.now(), 5000.00);
			accountRepository.save(accountMelba);
			melba.addAccount(accountMelba);

			Account accountMelba2 = new Account("VIN002", LocalDate.now().plusDays(1), 7500.00);
			accountRepository.save(accountMelba2);
			melba.addAccount(accountMelba2);

			Account accountAngel = new Account("VIN003", LocalDate.now().plusDays(1), 6000.00);
			accountRepository.save(accountAngel);
			angel.addAccount(accountAngel);

			Account accountAngel2 = new Account("VIN004",LocalDate.now().plusDays(2),7000.00);
            accountRepository.save(accountAngel2);
			angel.addAccount(accountAngel2);



			Transaction buyAmazon = new Transaction(DEBIT, "He made a purchase at the Amazon Store for an Automatic Washing Machine.", LocalDateTime.now(), -300.00);
			transactionRepository.save(buyAmazon);
			accountMelba.addTransaction(buyAmazon);

			Transaction transfer = new Transaction(CREDIT, "Transfer of Julio Perez", LocalDateTime.now().plusDays(2), 500.00);
			transactionRepository.save(transfer);
			accountMelba.addTransaction(transfer);

			Transaction otherBuyAmazon = new Transaction(DEBIT, "Buy Notebook HP", LocalDateTime.now().plusDays(4), -3000.0);
			transactionRepository.save(otherBuyAmazon);
			accountMelba2.addTransaction(otherBuyAmazon);



			Loan mortgage = new Loan("Hipoteca", 500000.00, Arrays.asList(12, 24, 36, 48, 60));
			loanRepository.save(mortgage);

			Loan personal = new Loan("Personal", 100000.00, Arrays.asList(6, 12, 24));
			loanRepository.save(personal);

			Loan automotive  = new Loan("Automotive",300000.00, Arrays.asList(6,12,24,36));
            loanRepository.save(automotive);



			ClientLoan melbaMortgage = new ClientLoan(melba, mortgage, 400000.00, 60);
			clientRepository.save(melba);
			melba.addClientLoan(melbaMortgage);

			ClientLoan melbaPersonal = new ClientLoan(melba, personal, 50000.00, 12);
			clientRepository.save(melba);
			melba.addClientLoan(melbaPersonal);

			ClientLoan melbaAutomotive =new ClientLoan(melba,automotive,300000.00,36);
            clientRepository.save(melba);
			angel.addClientLoan(melbaAutomotive);


			ClientLoan angelPersonal=new ClientLoan(angel,personal,100000.00,24);
			clientRepository.save(angel);
			angel.addClientLoan(angelPersonal);

			ClientLoan angelAutomotive =new ClientLoan(angel,automotive,200000.00,36);
			clientRepository.save(angel);
			angel.addClientLoan(angelAutomotive);

			clientLoanRepository.save(melbaMortgage);
			clientLoanRepository.save(melbaPersonal);
			clientLoanRepository.save(melbaAutomotive);

			clientLoanRepository.save(angelPersonal);
			clientLoanRepository.save(angelAutomotive);

		};
	}
}