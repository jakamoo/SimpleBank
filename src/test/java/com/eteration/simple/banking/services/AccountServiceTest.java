package com.eteration.simple.banking.services;

import com.eteration.simple.banking.exception.InsufficientBalanceException;
import com.eteration.simple.banking.model.dto.ResponseDTO;
import com.eteration.simple.banking.model.entity.AccountEntity;
import com.eteration.simple.banking.model.entity.WithdrawalTransactionEntity;
import com.eteration.simple.banking.repository.AccountRepository;
import com.eteration.simple.banking.repository.TransactionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class AccountServiceTest {


    @MockBean
    private AccountRepository accountRepository;

    @MockBean
    private TransactionRepository transactionRepository;

    @MockBean
    private AccountService accountService;

    @Test
    public void testDebit() throws InsufficientBalanceException {
        String accountNumber = "12345";
        double amount = 100.0;
        AccountEntity mockAccount = new AccountEntity();
        mockAccount.setBalance(200.0);

        when(accountRepository.findByAccountNumber(any())).thenReturn(Optional.of(mockAccount));

        ResponseDTO result = accountService.debit(accountNumber, amount);

        Assertions.assertEquals(mockAccount.hashCode(), result.getApprovalCode());
        Assertions.assertEquals(100.0, mockAccount.getBalance(), 0.01);
        verify(transactionRepository, times(1)).save(any(WithdrawalTransactionEntity.class));
    }
}

