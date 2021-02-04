package com.miguelms.bank.repository;

import com.miguelms.bank.dao.BankAccountDAO;
import com.miguelms.bank.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository <User, Long> {

    @Query(value = "select * from BANK_ACCOUNT where id in (SELECT bank_accounts_id FROM USER_BANK_ACCOUNTS  where user_id = ?1)", nativeQuery = true)
    List <BankAccountDAO> getBankAccountsFromUserId(Long userId);


}
