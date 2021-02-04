package com.miguelms.bank.validator;

import com.miguelms.bank.model.Card;
import com.miguelms.bank.service.CardService;
import com.miguelms.bank.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BankValidators {

    @Autowired
    CardService cardService;

    public boolean validatePin(String cardNumber, String pin){
        Optional <Card> card = cardService.findByCardnumber(cardNumber);
        if(card.isPresent()){
            if(Utils.encryptMd5(pin).equals(card.get().getPin()))
                return true;
        }
        return false;
    }
}
