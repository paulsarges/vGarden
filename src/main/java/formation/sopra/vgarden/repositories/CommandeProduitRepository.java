package formation.sopra.vgarden.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import formation.sopra.vgarden.model.CommandeProduit;
import formation.sopra.vgarden.model.CommandeProduitKey;

public interface CommandeProduitRepository extends JpaRepository<CommandeProduit, CommandeProduitKey> {
}
