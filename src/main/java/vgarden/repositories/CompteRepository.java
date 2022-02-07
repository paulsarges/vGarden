package vgarden.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vgarden.model.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long>  {
}
