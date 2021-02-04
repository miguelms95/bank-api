package com.miguelms.bank.service;

import com.miguelms.bank.model.Card;

import java.util.Optional;

public interface CardService {

    boolean activateCard(String cardNumber);

    Optional<Card> findByCardnumber(String cardNumber);
}
