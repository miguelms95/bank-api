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

import java.util.HashMap;
import java.util.List;

@RestController
public class AtmController {

    @Autowired
    BankAccountService bankAccountService;

    @GetMapping(value = "accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getBankAccounts(@RequestParam(value = "userId") String userId){

        List <BankAccountDAO> result = bankAccountService.getBankAccountsbyUserId(Long.valueOf(userId));
        if(result.isEmpty())
            return new ResponseEntity("", HttpStatus.NOT_FOUND);
        return new ResponseEntity("", HttpStatus.OK);
    }

    @GetMapping(value ="getMoney", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getMoney(
            @RequestParam(value = "bankAccountId") String bankAccountId,
            @RequestParam(value = "quantity") Double quantity
    ){
        // validate
        boolean result = bankAccountService.getMoney(Long.valueOf(bankAccountId), quantity);

        HashMap <String, String> response = new HashMap <>();

        if(result) {
            response.put("message", String.format("Succesfully operation, get %s €", quantity) );
            return new ResponseEntity(response, HttpStatus.NOT_FOUND);
        }
        response.put("message", "error while processing operation");
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping(value ="putMoney", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity putMoney(
            @RequestParam(value = "bankAccountId") String bankAccountId,
            @RequestParam(value = "quantity") Double quantity
    ){
        // validate
        boolean result = bankAccountService.putMoney(Long.valueOf(bankAccountId), quantity);

        HashMap <String, String> response = new HashMap <>();

        if(result) {
            response.put("message", String.format("Succesfully operation, get %s €", quantity) );
            return new ResponseEntity(response, HttpStatus.NOT_FOUND);
        }
        response.put("message", "error while processing operation");
        return new ResponseEntity(response, HttpStatus.OK);
    }

}
