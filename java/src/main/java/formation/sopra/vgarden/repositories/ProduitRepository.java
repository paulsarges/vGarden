package formation.sopra.vgarden.repositories;

import formation.sopra.vgarden.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long>  {
}
