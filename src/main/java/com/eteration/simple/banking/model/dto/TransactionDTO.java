package com.eteration.simple.banking.model.dto;


import com.eteration.simple.banking.model.constant.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@AllArgsConstructor
@Data
public class TransactionDTO {
    private Double amount;
    private Date date;

    private TransactionType transactionType;

    private String approvalCode;

}