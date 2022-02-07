package vgarden.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import vgarden.model.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long>  {
	Optional<Compte> findByloginAndPassWord(@Param("compte") Compte compte);
}
