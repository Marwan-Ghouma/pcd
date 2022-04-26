package net.codejava.service;


import net.codejava.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import net.codejava.repository.TransactionRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransactionService {
    @Autowired
    private TransactionRepository repository ;

    public List<Transaction> getAdminCheques(long id) { return repository.getAdminsTransaction(id) ;
    }
    public List<Transaction> getClientCheques(long id) { return repository.getClientsTransaction(id) ;
    }

    public Transaction saveCheque(Transaction cheque) { return repository.save(cheque) ;
    }
}
