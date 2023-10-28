package com.eteration.simple.banking.model;

// This class is a place holder you can change the complete implementation

import com.eteration.simple.banking.exception.InsufficientBalanceException;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Data
public class Account {
    private String owner;
    private String accountNumber;
    private Double balance;
    private List<Transaction> transactions = new ArrayList<>();


    public void credit(double amount) {
        this.balance += amount;
        transactions.add(new DepositTransaction(amount));
    }

    public void debit(double amount) throws InsufficientBalanceException {
        if (amount <= balance) {
            this.balance -= amount;
            transactions.add(new WithdrawalTransaction(amount));
        } else {
            throw new InsufficientBalanceException(balance,amount);
        }
    }

}
