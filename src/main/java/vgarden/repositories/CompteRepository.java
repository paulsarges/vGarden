package vgarden.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vgarden.model.Compte;

import java.util.Optional;

public interface CompteRepository extends JpaRepository<Compte, Long>  {
	@Query("c from Compte c where c.login=:login and c.password=:password")
	Optional<Compte> findByloginAndPassWord(@Param("login") String login, @Param("password") String password);
}
