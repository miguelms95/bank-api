package com.miguelms.bank.services;

import com.miguelms.bank.dao.BankAccountDAO;
import com.miguelms.bank.service.BankAccountService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
@Slf4j
public class BankAccountServiceTest {

    @Autowired
    BankAccountService service;

    @Test
    public void testGetBankAccountsbyCardNumber(){

        List <BankAccountDAO> list = service.getBankAccountsbyUserId(1l);
        for (BankAccountDAO bankAccount : list) {
            log.info(bankAccount.toString());
        }
        Assert.isTrue(!list.isEmpty(), "no bank account detected");
    }

}
