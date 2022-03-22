package net.codejava.service;


import net.codejava.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import net.codejava.repository.TransactionRepository;

import java.util.List;

public class TransactionService {
    @Autowired
    private TransactionRepository repository ;
    public Transaction saveTransaction(Transaction transaction){return repository.save(transaction); }
    public List<Transaction> getTransactions(){
        return repository.findAll();
    }
    public Transaction getTransactionById(Long id){
        return repository.findById(id).orElse(null);
    }
    public Transaction getReceivedTransaction(long receiver){
        return repository.getReceivedTransaction(receiver);
    }
    public Transaction getSentTransaction(long sender){
        return repository.getSentTransaction(sender);
    }

}
