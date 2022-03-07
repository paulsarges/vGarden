package formation.sopra.vgarden.repositories;

import java.util.List;
import java.util.Optional;

import formation.sopra.vgarden.model.Plante;
import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.vgarden.model.Terrain;
import formation.sopra.vgarden.model.TypeDeSol;
import formation.sopra.vgarden.model.Utilisateur;

public interface TerrainRepository extends JpaRepository<Terrain, Long>{

	Optional<Terrain> findById(Long id);

	List<Terrain> findByLocalisation(String localisation);

	List<Terrain> findByTypeDeSol(TypeDeSol typeDeSol);

	List<Terrain> findByPlantes(Plante plante);

	List<Terrain> findByUtilisateur(Utilisateur utilisateur);
}
