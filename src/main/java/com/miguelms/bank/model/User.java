package com.miguelms.bank.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class User {

    @Id
    private Long id;
    private String name;

    public User() {
        bankAccounts = new HashSet <>();
        cards = new HashSet <>();
    }

    @EqualsAndHashCode.Exclude
    @ManyToMany
    private Set <BankAccount> bankAccounts;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany
    private Set <Card> cards;

    public User setBankAccounts(Set<BankAccount> bankAccounts){
        this.bankAccounts = bankAccounts;
        for (BankAccount bankAccount : bankAccounts) {
            bankAccount.getUsers().add(this);
        }
        return this;
    }
}
