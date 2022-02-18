package formation.sopra.vgarden.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import formation.sopra.vgarden.exceptions.CompteException;
import formation.sopra.vgarden.model.Compte;
import formation.sopra.vgarden.model.Utilisateur;
import formation.sopra.vgarden.repositories.CompteRepository;

@Service
public class CompteServices implements UserDetailsService{
	@Autowired
	private CompteRepository compteRepo;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private UtilisateurServices utilisateurServices;


	public Compte save(Compte c) {
		c.setPassword(encoder.encode(c.getPassword()));
		return compteRepo.save(c);
	}
	
//	public Compte updatePassword(Compte c, String username) {
//		Compte compteBase = compteRepo.findBylogin(username).orElseThrow(() ->
//		 	new CompteException("Erreur compte"));
//		compteBase.setPassword(encoder.encode(c.getPassword()));
//		return compteRepo.save(compteBase);
//		
//	}

	public void delete(Compte c) {
		if (c.getUtilisateur() != null) {
			utilisateurServices.deleteAfterCompte(c.getUtilisateur());
		}
		compteRepo.delete(c);
	}
	
	public Compte getByUtilisateur(Utilisateur u) {
		return compteRepo.findByUtilisateur(u);
	}
	
	public Compte getById(Long id) {
		return compteRepo.findById(id).orElseThrow(() ->
				new CompteException("Compte inexistant par find by id"));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return compteRepo.findBylogin(username).orElseThrow(() ->
				new CompteException("compte inexistant"));
	}
	
	
	public Compte addInformation(Compte c) {
		return null;
	}
}
