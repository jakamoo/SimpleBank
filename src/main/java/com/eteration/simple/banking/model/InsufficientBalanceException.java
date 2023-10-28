package com.eteration.simple.banking.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

// This class is a place holder you can change the complete implementation
@EqualsAndHashCode(callSuper = true)
@Data
public class InsufficientBalanceException extends Exception {
    private double requestedAmount;
    private double availableBalance;
    public InsufficientBalanceException(double requestedAmount, double availableBalance) {
        super("Insufficient balance. Requested: " + requestedAmount + ", Available: " + availableBalance + ".");
        this.requestedAmount = requestedAmount;
        this.availableBalance = availableBalance;
    }

}
