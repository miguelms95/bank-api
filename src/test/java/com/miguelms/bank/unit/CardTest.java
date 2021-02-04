package com.miguelms.bank.unit;

import com.miguelms.bank.model.*;
import com.miguelms.bank.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;

@Slf4j
public class CardTest {

    @Test
    public void testBankAccount() {
        Bank bank = new Bank().setId(1l).setName("ING");
        BankAccount account = new BankAccount().setId(1l).setBank(bank).setBalance(100.0);
        User user = new User().setId(1l).setName("Miguel Martinez").setBankAccounts(new ArrayList <>(Arrays.asList(account)));

        Card card = new Card().setId(1l).setBankAccount(account)
                .setCardNumber("4716252569506086")
                .setUser(user).setCardType(CardType.CREDIT).setActive(true).setPin(Utils.encryptMd5("1234"));

        log.info(bank.toString());
        log.info(account.toString());
        log.info(card.toString());


        log.info("compare: {} with {}", account.getCards(), card);
        Assert.isTrue(account.getCards().contains(card), "card not present in account");
        Assert.isTrue(card.getBankAccount().equals(account), "account not linked to card");

    }


}
