package com.eteration.simple.banking.controller;

import com.eteration.simple.banking.exception.InsufficientBalanceException;
import com.eteration.simple.banking.model.dto.AccountDTO;
import com.eteration.simple.banking.model.dto.RequestDTO;
import com.eteration.simple.banking.model.dto.ResponseDTO;
import com.eteration.simple.banking.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// This class is a place holder you can change the complete implementation
@RestController
@RequestMapping("/account/v1")
@RequiredArgsConstructor
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{accountNumber}")
    public ResponseEntity<AccountDTO> getAccount(@PathVariable String accountNumber) {
        AccountDTO accountDTO = accountService.getAccount(accountNumber);
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }

    @PostMapping("/credit/{accountNumber}")
    public ResponseEntity<ResponseDTO> credit(@RequestBody RequestDTO requestDTO, @PathVariable String accountNumber) {
        ResponseDTO approvalCode=accountService.credit(accountNumber,requestDTO.getAmount());

        return new ResponseEntity<>(approvalCode,HttpStatus.OK);
    }
    @PostMapping("/debit/{accountNumber}")
    public ResponseEntity<ResponseDTO>debit(@RequestBody RequestDTO requestDTO,@PathVariable String accountNumber) throws InsufficientBalanceException {
        ResponseDTO approvalCode=accountService.debit(accountNumber,requestDTO.getAmount());

        return new ResponseEntity<>(approvalCode,HttpStatus.OK);
	}
}