package formation.sopra.vgarden.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import formation.sopra.vgarden.model.Compte;

import java.util.Optional;

public interface CompteRepository extends JpaRepository<Compte, Long>  {
	@Query("select c from Compte c where c.login=:login")
	Optional<Compte> findBylogin(@Param("login") String login);
}