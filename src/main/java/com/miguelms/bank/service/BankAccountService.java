package com.miguelms.bank.service;

import com.miguelms.bank.model.Activity;
import com.miguelms.bank.model.BankAccount;

import java.util.List;

public interface BankAccountService {

    List <BankAccount> getBankAccountsFromCardNumber(String cardNumber);

    boolean getMoney(Long accountId, double quantity);

    boolean putMoney(Long valueOf, Double quantity);

    List<Activity> getActivity(String cardNumber);
}
