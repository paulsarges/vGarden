package formation.sopra.vgarden.repositories;

import java.util.Optional;

import formation.sopra.vgarden.model.Plante;
import formation.sopra.vgarden.model.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface PlanteRepository extends JpaRepository<Plante, Long> {

	Optional<Plante> findByTerrain(@Param("terrain") Terrain terrain);


	}
