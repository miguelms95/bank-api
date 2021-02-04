package com.miguelms.bank.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
public class AtmController {

    @GetMapping(value = "accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAccounts(@RequestParam String cardNumber){

        return new ResponseEntity("", HttpStatus.OK);
    }

}