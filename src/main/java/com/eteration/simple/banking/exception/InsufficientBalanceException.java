package com.eteration.simple.banking.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class InsufficientBalanceException extends Exception {

    private double requestedAmount;
    private double availableBalance;
    public InsufficientBalanceException() {
        super("Insufficient balance.");
    }

    public InsufficientBalanceException(String message) {
        super(message);
    }

    public InsufficientBalanceException(double requestedAmount, double availableBalance) {
        super("Insufficient balance. Requested: " + requestedAmount + ", Available: " + availableBalance + ".");
        this.requestedAmount = requestedAmount;
        this.availableBalance = availableBalance;
    }
}
