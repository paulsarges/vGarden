package formation.sopra.vgarden.restController;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.vgarden.exceptions.CompteException;
import formation.sopra.vgarden.exceptions.UtilisateurException;
import formation.sopra.vgarden.model.Compte;
import formation.sopra.vgarden.model.Role;
import formation.sopra.vgarden.model.TypeCompte;
import formation.sopra.vgarden.model.Utilisateur;
import formation.sopra.vgarden.model.Views;
import formation.sopra.vgarden.repositories.CompteRepository;
import formation.sopra.vgarden.services.CompteServices;
import formation.sopra.vgarden.services.UtilisateurServices;

@RestController
@RequestMapping("/auth")
public class CompteRestController {
	@Autowired
	private CompteServices compteServices;
	@Autowired
	private UtilisateurServices utilisateurServices;
	@Autowired
	private CompteRepository compteRepo;
	
	@GetMapping("")
	public void auth(@AuthenticationPrincipal Compte c ) {
		System.out.println(c.getUsername());
		System.out.println(c.getPassword());
		System.out.println(c.getRole());
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(Views.Common.class)
	public Compte inscription(@Valid @RequestBody Compte c, BindingResult br) {
		if (br.hasErrors()) {
			throw new CompteException("Données incorrectes");
		}
		if (compteRepo.findBylogin(c.getLogin()).isPresent()) {
			throw new CompteException("Utilisateur existant");
		}
		c.setRole(Role.ROLE_USER);
		return compteServices.save(c);
	}
	
	@PostMapping("/utilisateur")
	@JsonView(Views.Common.class)
	public Utilisateur addUtilisateur(@AuthenticationPrincipal Compte c,@Valid @RequestBody Utilisateur u, BindingResult br) {
		if (br.hasErrors()) {
			throw new UtilisateurException("Données utilisateur incorrectes");
		}
		else {
			if (c.getUtilisateur() == null) {
				u.setTypeCompte(TypeCompte.Particulier);
				c.setUtilisateur(u);
				u.setCompte(c);
			}
			else {
				throw new CompteException("Utilisateur existant");
			}
		}
		return utilisateurServices.create(u);
	}
	
	@DeleteMapping("/suppression")
	public void deleteCompte(@AuthenticationPrincipal Compte c) {
		compteServices.delete(c);
	}
	
//	@PutMapping("/modifier/{username}")
//	@JsonView(Views.Common.class)
//	public Compte modifierPassword(@AuthenticationPrincipal Compte c, @RequestParam String username) {
//		return compteServices.updatePassword(c, username);
//	}
	
}
