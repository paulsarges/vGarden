package vgarden.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vgarden.model.CommandeProduit;
import vgarden.model.CommandeProduitKey;

public interface CommandeProduitRepository extends JpaRepository<CommandeProduit, CommandeProduitKey> {
}
