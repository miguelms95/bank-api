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
public class Card {

    @Id
    private Long id;
    @EqualsAndHashCode.Exclude private CardType cardType;
    @EqualsAndHashCode.Exclude private boolean active;
    @EqualsAndHashCode.Exclude private String pin; // encoded
    @EqualsAndHashCode.Exclude private double limit;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    private BankAccount bankAccount;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    private User user;

    public Card setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        bankAccount.getCards().add(this);
        return this;
    }

    public Card setUser(User user) {
        this.user = user;
        user.getCards().add(this);
        return this;
    }
}
