package net.codejava;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {

	@Autowired private RoleRepository repo;

	@Test
	public void testCreateRoles() {
		Role user = new Role("ROLE_User");
		Role admin = new Role("ROLE_Admin");
		Role customer = new Role("ROLE_Customer");

		repo.saveAll(List.of(user, admin, customer));

		List<Role> listRoles = repo.findAll();

		assertThat(listRoles.size()).isEqualTo(3);
	}

}
