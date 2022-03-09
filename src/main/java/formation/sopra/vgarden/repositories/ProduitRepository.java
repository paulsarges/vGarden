package formation.sopra.vgarden.repositories;

import formation.sopra.vgarden.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import formation.sopra.vgarden.model.Utilisateur;
import java.util.List;
import java.util.Optional;

public interface ProduitRepository extends JpaRepository<Produit, Long>  {
	List<Produit> findByUtilisateur(Utilisateur utilisateur);
}
