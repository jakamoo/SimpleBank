package com.eteration.simple.banking.services.mapper;

import com.eteration.simple.banking.model.dto.AccountDTO;
import com.eteration.simple.banking.model.entity.AccountEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AccountMapper {

    private final TransactionMapper transactionMapper;

    public AccountDTO entityToDto(AccountEntity accountEntity) {

        return new AccountDTO(accountEntity.getOwner(),
                accountEntity.getAccountNumber(),
                accountEntity.getBalance(),
                accountEntity.getCreateDate(),
                accountEntity.getTransactions().stream()
                        .map(transactionMapper::entityToDto)
                        .collect(Collectors.toList()
        ));

    }

}
