package formation.sopra.vgarden.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import formation.sopra.vgarden.model.FicheMaladie;

public interface FicheMaladieRepository extends JpaRepository<FicheMaladie, Long> {
	
	Optional<FicheMaladie> findByNom(String nom);
}

