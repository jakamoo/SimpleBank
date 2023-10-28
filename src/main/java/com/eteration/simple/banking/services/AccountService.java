package com.eteration.simple.banking.services;

import com.eteration.simple.banking.exception.InsufficientBalanceException;
import com.eteration.simple.banking.model.dto.AccountDTO;
import com.eteration.simple.banking.model.dto.ResponseDTO;
import com.eteration.simple.banking.model.entity.AccountEntity;
import com.eteration.simple.banking.model.entity.BaseTransactionEntity;
import com.eteration.simple.banking.model.entity.DepositTransactionEntity;
import com.eteration.simple.banking.repository.AccountRepository;
import com.eteration.simple.banking.repository.TransactionRepository;
import com.eteration.simple.banking.services.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.eteration.simple.banking.model.entity.WithdrawalTransactionEntity;

import java.util.Date;
import java.util.Optional;

// This class is a place holder you can change the complete implementation
@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    private final AccountMapper accountMapper;

    public AccountDTO getAccount(String accountNumber){
        Optional<AccountEntity> accountEntity = accountRepository.findByAccountNumber(accountNumber);

        if(accountEntity.isEmpty()){
            throw new RuntimeException("account couldnt find!");
        }

        return accountMapper.entityToDto(accountEntity.get());
    }

    public ResponseDTO credit(String accountNumber, double amount) {
        AccountEntity account = getAccountByNumber(accountNumber);
        updateAccountBalanceForCredit(account, amount);
        DepositTransactionEntity depositTransaction = (DepositTransactionEntity)createAndSaveTransaction(account,new DepositTransactionEntity(amount));
        return new ResponseDTO(depositTransaction.hashCode());
    }



    private void updateAccountBalanceForCredit(AccountEntity account, double amount) {
        account.setBalance(account.getBalance() + amount);
    }

    private BaseTransactionEntity createAndSaveTransaction(AccountEntity account, BaseTransactionEntity transaction) {
        transaction.setAccountId(account.getId());
        transaction.setDate(new Date());
        transactionRepository.save(transaction);
        return transaction;
    }

    public ResponseDTO debit(String accountNumber, double amount) throws InsufficientBalanceException {

        AccountEntity account = getAccountByNumber(accountNumber);
        validateSufficientBalance(account, amount);

        updateAccountBalance(account, amount);
        WithdrawalTransactionEntity withdrawalTransaction = (WithdrawalTransactionEntity) createAndSaveTransaction(account,new WithdrawalTransactionEntity(amount));

        return new ResponseDTO(withdrawalTransaction.hashCode());
    }

    private AccountEntity getAccountByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account couldn't be found!"));
    }

    private void validateSufficientBalance(AccountEntity account, double amount) throws InsufficientBalanceException {
        if (account.getBalance() < amount) {
            throw new InsufficientBalanceException(amount, account.getBalance());
        }
    }

    private void updateAccountBalance(AccountEntity account, double amount) {
        account.setBalance(account.getBalance() - amount);
    }



}
