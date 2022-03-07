package formation.sopra.vgarden.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.vgarden.model.Compte;
import formation.sopra.vgarden.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	Optional<Utilisateur> findByCompte(Compte c);
}
