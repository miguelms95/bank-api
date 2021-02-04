package com.miguelms.bank.repository;

import com.miguelms.bank.model.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository <Card, Long> {
}
