package com.miguelms.bank.service;

import com.miguelms.bank.dao.BankAccountDAO;
import com.miguelms.bank.model.BankAccount;

import java.util.List;

public interface BankAccountService {

    List <BankAccount> getBankAccountsbyCardNumber(String cardNumber);

    List <BankAccountDAO> getBankAccountsbyUserId(Long userId);

    boolean getMoney(Long accountId, double quantity);

    boolean putMoney(Long valueOf, Double quantity);
}
