package com.miguelms.bank.service.impl;

import com.miguelms.bank.model.Activity;
import com.miguelms.bank.model.BankAccount;
import com.miguelms.bank.model.Card;
import com.miguelms.bank.model.User;
import com.miguelms.bank.repository.BankAccountRepository;
import com.miguelms.bank.repository.CardRepository;
import com.miguelms.bank.repository.UserRepository;
import com.miguelms.bank.service.BankAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    BankAccountRepository repository;
    @Autowired
    CardRepository cardRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    BankAccountRepository bankAccountRepository;

    @Override
    public List <BankAccount> getBankAccountsFromCardNumber(String cardNumber) {
        Optional <Card> card = cardRepository.findByCardNumber(cardNumber);
        log.info(card.toString());
        if (card.isPresent()) {
            User user = card.get().getUser();
            List <BankAccount> accounts = user.getBankAccounts();
            List<BankAccount> result = new ArrayList<>();

            for (BankAccount account : accounts) {
                // filter musn't get accounts from other banks, just from the same
                if (account.getBank().getId().equals(card.get().getBankAccount().getBank().getId()))
                    result.add(account);
            }
            return result;
        }

        return new ArrayList <>();
    }

    @Override
    public boolean getMoney(Long accountId, double quantity) {
        Optional <BankAccount> account = bankAccountRepository.findById(accountId);
        if(account.isPresent()){
            BankAccount tmpAccount = account.get();
            if(tmpAccount.getBalance() >= quantity){
                tmpAccount.setBalance(tmpAccount.getBalance() - quantity);
                log.info("Account: {}, extracted {} €", tmpAccount, quantity);
                bankAccountRepository.save(tmpAccount);
                return true;
            }
            log.info("Not enough money in account");
        }

        return false;
    }

    @Override
    public boolean putMoney(Long accountId, Double quantity) {
        Optional <BankAccount> account = bankAccountRepository.findById(accountId);
        if(account.isPresent()){
            BankAccount tmpAccount = account.get();
            tmpAccount.setBalance(tmpAccount.getBalance() + quantity);
            repository.save(tmpAccount);
            log.info("Account: {}, added {} €", tmpAccount, quantity);
        }

        return false;
    }

    @Override
    public List <Activity> getActivity(String cardNumber) {
        List <BankAccount> accounts = getBankAccountsFromCardNumber(cardNumber);
        List<Activity> activities = new ArrayList <>();
        for (BankAccount account : accounts) {
            activities.addAll(account.getActivity());
        }
        return activities;

    }
}
