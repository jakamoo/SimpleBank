package com.eteration.simple.banking.model.entity;

import com.eteration.simple.banking.model.constant.TransactionType;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="transaction")
@Data
public abstract class BaseTransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double amount;
    private Date date;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private Long accountId;

    public BaseTransactionEntity(Double amount,TransactionType transactionType){
        this.amount=amount;
        this.transactionType=transactionType;
    };

    public BaseTransactionEntity() {

    }
}
