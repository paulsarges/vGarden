package formation.sopra.vgarden.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import formation.sopra.vgarden.model.FichePlante;

public interface FichePlanteRepository extends JpaRepository<FichePlante, Long> {
	
	Optional<FichePlante> findByNom(String nom);
}
