package vgarden.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import vgarden.model.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    // @Query("SELECT c from Commande c join fetch c.commandeProduits where c.id=:id")
    @EntityGraph(value = "Commande.CommandeProduits", type = EntityGraph.EntityGraphType.FETCH)
    Commande findByIdAndFetchCommandeProduits(Long id);
}
