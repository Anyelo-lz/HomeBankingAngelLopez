package com.mindhub.homebanking.Dto;
import com.mindhub.homebanking.models.Client;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


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
        this.accounts = client.getAccounts().stream().map(AccountDTO::new).collect(Collectors.toSet());
        this.loans = client.getClientLoans().stream().map(clientLoan -> new LoanDTO(clientLoan.getLoan())).collect(Collectors.toList());
    }


    public List<LoanDTO> getLoans() {
        return loans;
    }
    public ClientDTO() {
    }

    public void setLoans(List<LoanDTO> loans) {
        this.loans = loans;
    }
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastNAme() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Set<AccountDTO> getAccounts() {
        return accounts;
    }

}