package net.codejava.admin;

import net.codejava.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AdminRepo extends JpaRepository<User, Long> {

    @Query("SELECT c FROM Admin c WHERE c.email = ?1")
    public Admin findByEmail(String email);

    @Query(nativeQuery = true,value = "SELECT c FROM User c WHERE c.id IN (select* from users_roles e where e.role_id = 1)"

    )
    List<User> finAll();

    @Query("SELECT c FROM User c WHERE c.rib = ?1")
    public User findByRib(String rib);
}


