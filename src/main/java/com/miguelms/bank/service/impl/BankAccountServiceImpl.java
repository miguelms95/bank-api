package com.miguelms.bank.service.impl;

import com.miguelms.bank.dao.BankAccountDAO;
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
    public List <BankAccount> getBankAccountsbyCardNumber(String cardNumber) {
        Optional <Card> card = cardRepository.findByCardNumber(cardNumber);
        log.info(card.toString());
        if (card.isPresent()) {
            User user = card.get().getUser();
            Iterable <BankAccount> accounts = bankAccountRepository.findAll();
            List<BankAccount> result = new ArrayList <>(); // crazy findAll and filter at application level
            accounts.forEach(account -> {
                if(account.getUsers().contains(user))
                    result.add(account);

            });
            return result;
        }

        return new ArrayList <>();
    }

    @Override
    public List <BankAccountDAO> getBankAccountsbyUserId(Long userId) {
        List<BankAccountDAO> b = userRepository.getBankAccountsFromUserId(userId);
        return b;
    }
}
