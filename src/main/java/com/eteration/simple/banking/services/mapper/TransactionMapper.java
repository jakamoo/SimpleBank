package com.eteration.simple.banking.services.mapper;
import com.eteration.simple.banking.model.dto.TransactionDTO;
import com.eteration.simple.banking.model.entity.BaseTransactionEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    public TransactionDTO entityToDto(BaseTransactionEntity transactionEntity) {
        String approvalCode= String.valueOf(transactionEntity.hashCode());
        return new TransactionDTO(transactionEntity.getAmount(),
                transactionEntity.getDate(),
                transactionEntity.getTransactionType(),
                approvalCode

        );

    }
}
