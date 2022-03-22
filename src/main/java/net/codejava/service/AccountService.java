package net.codejava.service;


import net.codejava.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.codejava.repository.AccountRepository;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository repository;

    public Account saveAccount(Account account) {
        return repository.save(account);
    }

    public List<Account> saveAccounts(List<Account> accounts){
       return repository.saveAll(accounts);
    }
    public List<Account> getAccounts(){
        return repository.findAll();
    }
    public Account getAccountById(int id){
        return repository.findById(id).orElse(null);
    }
    public Account getAccountByAccountNumber(String number){
        return (Account) repository.findByAccountNumber(number).orElse(null);
    }
    public Account updateAccount(Double amount,Account account){
        //Account exist=repository.findById(account.getId()).orElse(null);
         account.setCurrentBalance(amount);
           return (account) ;
    }

}
