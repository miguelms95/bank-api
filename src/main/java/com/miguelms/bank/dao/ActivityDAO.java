package com.miguelms.bank.dao;

import com.miguelms.bank.model.Activity;
import com.miguelms.bank.model.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class ActivityDAO {

    private Long id;
    private ActivityType activityType;
    private double quantity;
    private Date date;

    private Long bankAccountId;

    public ActivityDAO(Activity activity){
        this.id = activity.getId();
        activityType = activity.getActivityType();
        quantity = activity.getQuantity();
        date = activity.getDate();
        bankAccountId = activity.getBankAccount().getId();
    }

}
