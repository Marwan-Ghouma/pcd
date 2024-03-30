package net.codejava.repository;


import net.codejava.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    @Query("FROM Account WHERE accountNumber = ?1")
    Optional<Object> findByAccountNumber(String number);
}
