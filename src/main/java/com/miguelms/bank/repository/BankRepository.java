package com.miguelms.bank.repository;

import com.miguelms.bank.model.Bank;
import org.springframework.data.repository.CrudRepository;

public interface BankRepository extends CrudRepository <Bank, Long> {
}
