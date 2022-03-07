package formation.sopra.vgarden.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import formation.sopra.vgarden.model.FicheRavageur;

public interface FicheRavageurRepository extends JpaRepository<FicheRavageur, Long> {
	
	Optional<FicheRavageur> findByNom(String nom);
}
