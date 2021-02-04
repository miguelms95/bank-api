package com.miguelms.bank.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@With
public class BankAccount {

    @Id
    private Long id;
    private Double balance;

    @EqualsAndHashCode.Exclude
    @ManyToOne
    private Bank bank;

    @EqualsAndHashCode.Exclude
    @ManyToMany
    private Set <User> users;
}
