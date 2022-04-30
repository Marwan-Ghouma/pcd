package net.codejava.model;

import ch.qos.logback.core.net.server.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.codejava.User;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class  Transaction {
    @Id

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_seq")
    private long id;

    private long AdminId;


    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User client;

    private String targetOwnerName;

    private double amount;
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String reference;


}
