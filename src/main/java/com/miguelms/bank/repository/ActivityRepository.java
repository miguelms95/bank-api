package com.miguelms.bank.repository;

import com.miguelms.bank.model.Activity;
import org.springframework.data.repository.CrudRepository;

public interface ActivityRepository extends CrudRepository <Activity, Long> {
}
