package formation.sopra.vgarden.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.sopra.vgarden.model.Compte;
import formation.sopra.vgarden.model.Utilisateur;

public interface CompteRepository extends JpaRepository<Compte, Long>  {
	@Query("select c from Compte c where c.login=:login")
	Optional<Compte> findBylogin(@Param("login") String login);

	Compte findByUtilisateur(Utilisateur utilisateur);
}
