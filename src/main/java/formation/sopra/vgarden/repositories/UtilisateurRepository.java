package formation.sopra.vgarden.repositories;


import formation.sopra.vgarden.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
}
