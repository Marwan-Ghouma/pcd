package net.codejava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ACCOUNTS")
public class Account {
    @Id
    @GeneratedValue
    private int id;

    private String sortCode;

    @Column(unique = true)
    private String accountNumber;

    private double currentBalance;

    private String bankName;

    private String ownerName;
}
