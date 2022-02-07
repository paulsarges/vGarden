package vgarden.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import vgarden.model.Plante;
import vgarden.model.Terrain;
import vgarden.model.TypeDeSol;
import vgarden.model.Utilisateur;

public interface TerrainRepository extends JpaRepository<Terrain, Long>{

	Optional<Terrain> findById(Long id);
	
	List<Terrain> findByLocalisation(String localisation);
	
	List<Terrain> findByTypeDeSol(TypeDeSol typeDeSol);
	
	List<Terrain> findByPlantes(Plante plante);
	
	List<Terrain> findByUtilisateur(Utilisateur utilisateur);
}
