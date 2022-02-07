package vgarden.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import vgarden.model.Compte;
import vgarden.model.Plante;

public interface planteRepository extends JpaRepository<Plante, Long> {

	Optional<Plante> findbyTerrain(@Param("Plante") Plante plante);
}
