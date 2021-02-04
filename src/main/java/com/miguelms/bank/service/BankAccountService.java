package com.miguelms.bank.service;

import com.miguelms.bank.model.Activity;
import com.miguelms.bank.model.BankAccount;

import java.util.List;

public interface BankAccountService {

    List <BankAccount> getBankAccountsFromCardNumber(String cardNumber);

    List<Activity> getActivity(String cardNumber);

    boolean getCash(String cardNumber, Double quantity);

    boolean putCash(String cardNumber, Double quantity, Long atmId);
}
