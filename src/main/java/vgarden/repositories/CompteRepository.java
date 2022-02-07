package vgarden.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vgarden.model.Compte;

import java.util.Optional;

public interface CompteRepository extends JpaRepository<Compte, Long>  {
	Optional<Compte> findByLoginAndPassword(String login, String password);
}
