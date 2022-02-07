package vgarden.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import vgarden.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{

}
