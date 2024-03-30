package net.codejava.repository;


import net.codejava.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    @Query(" FROM Transaction WHERE AdminId = ?1")
    List<Transaction> getAdminsTransaction(long receiver);
    @Query(" FROM Transaction WHERE ClientId = ?1")
    List<Transaction>  getClientsTransaction(long sender);


}
