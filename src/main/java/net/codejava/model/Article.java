package net.codejava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ARTICLE")

public class Article {
    @Id
    @GeneratedValue
    private int id;


    private String codearticle;

    private String designation;

    private int  prixht;

    private int tauxtva;

    private int prixttc;





}
