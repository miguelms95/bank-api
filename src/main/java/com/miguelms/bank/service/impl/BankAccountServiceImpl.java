package com.miguelms.bank.service.impl;

import com.miguelms.bank.model.BankAccount;
import com.miguelms.bank.repository.BankAccountRepository;
import com.miguelms.bank.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    BankAccountRepository repository;

    @Override
    public List <BankAccount> getBankAccounts(String cardNumber) {
        return null;
    }
}
