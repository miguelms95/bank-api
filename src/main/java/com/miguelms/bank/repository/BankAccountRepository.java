package com.miguelms.bank.repository;

import com.miguelms.bank.model.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepository extends CrudRepository <BankAccount, Long> {
}
