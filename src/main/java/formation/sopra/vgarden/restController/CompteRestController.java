package formation.sopra.vgarden.restController;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.vgarden.exceptions.CompteException;
import formation.sopra.vgarden.model.Compte;
import formation.sopra.vgarden.model.TypeCompte;
import formation.sopra.vgarden.model.Utilisateur;
import formation.sopra.vgarden.model.Views;
import formation.sopra.vgarden.repositories.CompteRepository;
import formation.sopra.vgarden.services.CompteServices;

@RestController
@RequestMapping("/auth")
public class CompteRestController {
	@Autowired
	private CompteServices compteServices;
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
	public Compte inscription(@Valid @RequestBody Utilisateur u, BindingResult br) {
		if (br.hasErrors()) {
			throw new CompteException("Données incorrectes");
		}
		if (compteRepo.findBylogin(u.getLogin()).isPresent()) {
			throw new CompteException("Utilisateur existant");
		}
		u.setTypeCompte(TypeCompte.Particulier);
		return compteServices.save(u);
	}
	
	
	
}
