package vgarden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vgarden.model.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    // Commande findByIdWithCommandeProduits(Long id);
}
