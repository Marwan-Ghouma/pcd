package net.codejava.repository;


import net.codejava.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    @Query(" FROM Transaction WHERE targetAccountId = ?1")
    Transaction getReceivedTransaction(long receiver);
    @Query(" FROM Transaction WHERE sourceAccountId = ?1")
    Transaction getSentTransaction(long sender);
}
