package com.miguelms.bank.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class BankAccountDAO {

    private Long id;

    private Double balance;
    private Double creditAvailable;
    private Double creditUsed;
    private Long bankId;

}
