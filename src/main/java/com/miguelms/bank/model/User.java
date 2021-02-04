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
public class User {

    @Id
    private Long id;

    @EqualsAndHashCode.Exclude
    @ManyToMany
    private Set <BankAccount> bankAccounts;
}
