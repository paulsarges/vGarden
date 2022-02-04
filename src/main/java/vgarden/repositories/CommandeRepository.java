package vgarden.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import vgarden.model.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    @EntityGraph(value = "Commande.CommandeProduits", type = EntityGraph.EntityGraphType.FETCH)
    Commande findByIdAndFetchCommandeProduits(Long id);
}
