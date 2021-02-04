package com.miguelms.bank.model;

import com.sun.org.apache.bcel.internal.generic.BALOAD;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class Bank {

    @Id
    private Long id;
    private String name;
    private Double taxesForOtherBanks;

    public Bank(){
        atmMachines = new ArrayList <>();
        bankAccounts = new ArrayList <>();
    }


    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "bank")
    private List <AtmMachine> atmMachines;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "bank")
    private List <BankAccount> bankAccounts;

}
