package com.miguelms.bank.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class BankAccount {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double balance;
    private Double creditAvailable;
    private Double creditUsed;

    @EqualsAndHashCode.Exclude @ToString.Exclude
    @ManyToOne
    private Bank bank;

    @EqualsAndHashCode.Exclude @ToString.Exclude
    @ManyToMany
    private Set <User> users;

    @EqualsAndHashCode.Exclude
    @ManyToMany
    private List <Card> cards;

    @EqualsAndHashCode.Exclude
    @ManyToMany
    private List <Activity> activity;

    public BankAccount(){
        users = new HashSet <>();
        activity = new ArrayList <>();
        cards = new ArrayList <>();
    }

    public BankAccount setBank(Bank bank){
        bank.getBankAccounts().add(this);
        this.bank = bank;
        return this;
    }

    public BankAccount setUsers(Set<User> users){
        for (User user : users) {
            user.getBankAccounts().add(this);
        }
        this.users = users;
        return this;
    }
}
