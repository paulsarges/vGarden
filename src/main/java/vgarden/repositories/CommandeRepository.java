package vgarden.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vgarden.model.Commande;

import java.util.Optional;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    //@EntityGraph(value = "Commande.CommandeProduits", type = EntityGraph.EntityGraphType.FETCH)
    @Query("SELECT c from Commande c join fetch c.commandeProduits where c.id=:id")
    Optional<Commande> findByIdWithCommandeProduits(@Param("id") Long id);
    // TODO: Complete query
    // @Query("SELECT c from Commande c join fetch c.commandeProduits cp where cp.id.produit.terrain.utilisateur = :utilisateur")
    // List<Commande> findByVendeurFetchCommandeProduits(@Param("utilisateur") Utilisateur utilisateur);
}
