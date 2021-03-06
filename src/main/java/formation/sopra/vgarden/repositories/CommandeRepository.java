package formation.sopra.vgarden.repositories;

import formation.sopra.vgarden.model.Commande;
import formation.sopra.vgarden.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    @Query("SELECT c from Commande c left join fetch c.commandeProduits where c.id=:id")
    Optional<Commande> findByIdWithCommandeProduits(@Param("id") Long id);

    @Query("SELECT DISTINCT c from Commande c join fetch c.commandeProduits cp where cp.id.produit.plante.terrain.utilisateur = :utilisateur")
    List<Commande> findByUtilisateurVenteWithCommandeProduits(@Param("utilisateur") Utilisateur utilisateur);

    @Query("SELECT DISTINCT c from Commande c join fetch c.commandeProduits cp where c.utilisateur = :utilisateur")
    List<Commande> findByUtilisateurAchatWithCommandeProduits(@Param("utilisateur") Utilisateur utilisateur);
}
