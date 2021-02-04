package com.miguelms.bank.repository;

import com.miguelms.bank.model.AtmMachine;
import org.springframework.data.repository.CrudRepository;

public interface AtmMachineRepository extends CrudRepository <AtmMachine, Long> {
}
