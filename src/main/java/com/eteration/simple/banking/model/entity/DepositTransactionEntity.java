package com.eteration.simple.banking.model.entity;

import com.eteration.simple.banking.model.constant.TransactionType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "deposit_transaction")
@Data
@NoArgsConstructor

public class DepositTransactionEntity extends BaseTransactionEntity {

    public DepositTransactionEntity(Double amount){
        super(amount,TransactionType.DEPOSIT_TRANSACTION);
    }



}
