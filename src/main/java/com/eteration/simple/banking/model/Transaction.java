package com.eteration.simple.banking.model;


import com.eteration.simple.banking.exception.InsufficientBalanceException;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// This class is a place holder you can change the complete implementation
@Data
@NoArgsConstructor
public abstract class Transaction {
    double amount;
    Date date;

    Transaction(double amount){
        this.amount=amount;
        date = new Date();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", date=" + date +
                '}';
    }


    public abstract void execute(Account account) throws InsufficientBalanceException;

}
