package com.eteration.simple.banking.repository;

import com.eteration.simple.banking.model.entity.BaseTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<BaseTransactionEntity, Long> {

}
