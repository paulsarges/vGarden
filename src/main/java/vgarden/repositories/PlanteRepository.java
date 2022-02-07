package vgarden.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import vgarden.model.Terrain;
import vgarden.model.Plante;

public interface PlanteRepository extends JpaRepository<Plante, Long> {

	Optional<Plante> findByTerrain(@Param("terrain") Terrain terrain);
	
	}