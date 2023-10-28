package com.eteration.simple.banking.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
public class AccountDTO {
    private String owner;
    private String accountNumber;
    private Double balance;
    private Date createDate;

    private List<TransactionDTO> transactions;
}
