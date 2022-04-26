package net.codejava;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.verificationCode = ?1")
	public User findByVerificationCode(String code);

	@Query("SELECT c FROM User c WHERE c.email = ?1")
	public User findByEmail(String email);

	public User findByResetPasswordToken(String token);



}


