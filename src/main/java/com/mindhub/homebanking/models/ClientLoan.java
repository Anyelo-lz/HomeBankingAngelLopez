package com.mindhub.homebanking.models;

import jakarta.persistence.*;
import com.mindhub.homebanking.models.ClientLoan;

import java.util.List;
@Entity
public class ClientLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne()
    @JoinColumn(name = "loan_id")
    private Loan loan;

    private Double amount;
    private Integer payments;

    public ClientLoan(Client client, Loan loan, Double amount, Integer payments) {
        this.client = client;
        this.loan = loan;
        this.amount = amount;
        this.payments = payments;
    }

    public ClientLoan() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getPayments() {
        return payments;
    }

    public void setPayments(Integer payments) {
        this.payments = payments;
    }

    public Long getId() {
        return id;
    }
}

