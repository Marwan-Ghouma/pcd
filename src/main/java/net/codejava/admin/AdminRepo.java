package net.codejava.admin;

import net.codejava.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepo extends JpaRepository<User, Long> {

    @Query("SELECT c FROM Admin c WHERE c.email = ?1")
    public Admin findByEmail(String email);



}


