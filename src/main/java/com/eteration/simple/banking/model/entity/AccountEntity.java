package com.eteration.simple.banking.model.entity;

import lombok.Data;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Entity
@Table(name = "account")
@Data
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String accountNumber;
    private Double balance;
    private Date createDate;
    private String owner;

    @OneToMany(targetEntity = BaseTransactionEntity.class)
    @JoinColumn(name = "accountId")
    private List<BaseTransactionEntity> transactions = new ArrayList<>();

}

