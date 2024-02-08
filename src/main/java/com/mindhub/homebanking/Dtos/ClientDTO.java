package com.mindhub.homebanking.Dtos;
import com.mindhub.homebanking.models.Client;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import com.mindhub.homebanking.models.ClientLoan;


public class ClientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Set<AccountDTO> accounts;
    private List<LoanDTO> loans;

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.firstName = client.getName();
        this.lastName = client.getLastName();
        this.email = client.getEmail();
        this.accounts =client.getAccounts().stream().map(AccountDTO::new).collect(Collectors.toSet());
        this.loans = client.getLoans().stream().map((ClientLoan loan) -> new LoanDTO(loan.getLoan())).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Set<AccountDTO> getAccounts() {
        return accounts;
    }

    public List<LoanDTO> getLoans() {
        return loans;
    }
}