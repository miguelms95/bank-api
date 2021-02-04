package com.miguelms.bank.service;

import com.miguelms.bank.model.BankAccount;

import java.util.List;

public interface BankAccountService {

    List <BankAccount> getBankAccountsbyCardNumber(String cardNumber);

}
