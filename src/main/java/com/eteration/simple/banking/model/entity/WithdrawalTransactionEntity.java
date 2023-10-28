package com.eteration.simple.banking.model.entity;


import com.eteration.simple.banking.model.constant.TransactionType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

// This class is a place holder you can change the complete implementation
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "withdrawal_transaction")
@Data
@NoArgsConstructor
public class WithdrawalTransactionEntity extends BaseTransactionEntity {

    public WithdrawalTransactionEntity(Double amount) {
        super(amount,TransactionType.WITHDRAWAL_TRANSACTION);
    }
}


