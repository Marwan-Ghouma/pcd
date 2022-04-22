package net.codejava.controller;


import net.codejava.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import net.codejava.service.AccountService;

import java.util.List;

@Controller
public class AccountController {
    @Autowired
    private AccountService service;
    @PostMapping("/addAccount")
    public Account addAccount(@RequestBody Account account){
        return service.saveAccount(account);
    }
    @PostMapping("/addAccounts")
    public List<Account> addAccounts(@RequestBody List<Account> accounts){
        return service.saveAccounts(accounts);
    }
    @GetMapping("/accounts")
    public List<Account> findAllAccount(){
        return service.getAccounts();
    }
    @GetMapping("/account/{id}")
    public Account findById(@PathVariable int id){
        return service.getAccountById(id);
    }
    @GetMapping("/account/{name}")
    public Account findByAccountNumber(@PathVariable String name){
        return service.getAccountByAccountNumber(name);
    }
    @PutMapping("/updateAccount/{amount}")
    public Account updateAccount(@RequestBody Account account,@PathVariable Double amount){
        return service.updateAccount(amount,account);
    }
}
