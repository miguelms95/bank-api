package com.miguelms.bank.model;

import com.sun.org.apache.bcel.internal.generic.BALOAD;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class Bank {

    @Id
    private Long id;
    private String name;

    public Bank(){
        atmMachines = new HashSet <>();
        bankAccounts = new HashSet <>();
    }


    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "bank")
    private Set <AtmMachine> atmMachines;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "bank")
    private Set <BankAccount> bankAccounts;

}
