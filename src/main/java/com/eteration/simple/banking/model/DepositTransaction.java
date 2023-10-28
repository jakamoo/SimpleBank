package com.eteration.simple.banking.model;

import com.eteration.simple.banking.exception.InsufficientBalanceException;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

// This class is a place holder you can change the complete implementation
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "Deposit")
public class DepositTransaction extends Transaction {
    public DepositTransaction(double amount) {
        super(amount);
    }

    @Override
    public void execute(Account account) throws InsufficientBalanceException {
        double amount=getAmount();
        account.credit(amount);
    }
}
