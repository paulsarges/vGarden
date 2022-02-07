package vgarden.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vgarden.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>  {
}
