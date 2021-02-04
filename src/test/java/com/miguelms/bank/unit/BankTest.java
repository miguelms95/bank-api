package com.miguelms.bank.unit;

import com.miguelms.bank.model.AtmMachine;
import com.miguelms.bank.model.Bank;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class BankTest {

    @Test
    public void testModel() {
        Bank bank = new Bank().setId(1l).setName("ING");
        Assert.isTrue(bank.getId().equals(1l), "bank id not assigned");
        Assert.isTrue(bank.getName().equals("ING"), "bank name not assigned");
        Assert.isTrue(bank.getAtmMachines().isEmpty(), "atms empty");
        log.info("Bank model OK");
    }

    @Test
    public void testModelWithAtms() {
        Bank bank = new Bank().setId(1l).setName("ING");

        AtmMachine atm = new AtmMachine(1l, bank);

        Set <AtmMachine> atms = new HashSet <>(Arrays.asList(atm));
        bank.setAtmMachines(atms);

        log.info(bank.toString());
        log.info(atm.toString());

        Assert.isTrue(bank.getId().equals(1l), "bank id not assigned");
        Assert.isTrue(bank.getName().equals("ING"), "bank name not assigned");
        Assert.isTrue(!bank.getAtmMachines().isEmpty(), "atms empty");
        Assert.isTrue(bank.getAtmMachines().contains(atm), "atm not contained by bank");


        Assert.isTrue(atm.getBank().equals(bank),"bank not linked to ATM");
        log.info("Bank with ATMs OK");
    }
}
