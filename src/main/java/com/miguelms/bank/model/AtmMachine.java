package com.miguelms.bank.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AtmMachine {

    @Id
    private Long id;

    @EqualsAndHashCode.Exclude @ToString.Exclude
    @ManyToOne
    private Bank bank;
}
