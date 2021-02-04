package com.miguelms.bank.controller;

import com.miguelms.bank.dao.BankAccountDAO;
import com.miguelms.bank.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AtmController {

    @Autowired
    BankAccountService bankAccountService;

    @GetMapping(value = "accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getBankAccounts(@RequestParam String userId){

        List <BankAccountDAO> result = bankAccountService.getBankAccountsbyUserId(Long.valueOf(userId));
        if(result.isEmpty())
            return new ResponseEntity("", HttpStatus.NOT_FOUND);
        return new ResponseEntity("", HttpStatus.OK);
    }

}
