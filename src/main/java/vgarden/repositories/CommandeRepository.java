package vgarden.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vgarden.model.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    @Query("SELECT c from Commande c join fetch c.commandeProduits where c.id=:id")
    Commande findByIdFetchCommandeProduits(@Param("id") Long id);
}
