package com.miguelms.bank.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Activity {

    @Id
    private Long id;
    private ActivityType activityType;
    private double quantity;
    private Date date;

    @EqualsAndHashCode.Exclude @ToString.Exclude
    @ManyToOne
    private BankAccount bankAccount;

    public Activity setBankAccount(BankAccount bankAccount){
        this.bankAccount = bankAccount;
        bankAccount.getActivity().add(this);
        return this;
    }
}
