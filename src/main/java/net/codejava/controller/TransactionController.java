package net.codejava.controller;


import org.springframework.beans.factory.annotation.Autowired;
import net.codejava.service.TransactionService;

public class TransactionController {
    @Autowired
    public TransactionService service ;
}
