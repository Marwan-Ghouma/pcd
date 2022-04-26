package net.codejava.controller;


import net.codejava.model.Article;
import net.codejava.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import net.codejava.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class TransactionController {
    @Autowired
    public TransactionService service ;

    @PostMapping("/trans")
    public Transaction addCheque(@RequestBody Transaction cheque){
        return service.saveCheque(cheque);
    }
    @GetMapping("/admin/cheques/{id}")
    public List<Transaction> findAllCheque(@PathVariable long id){
        return service.getAdminCheques(id);
    }
    @GetMapping("/cheque/{id}")
    public List<Transaction> findByIdClient(@PathVariable long id){
        return service.getClientCheques(id);
    }

}
