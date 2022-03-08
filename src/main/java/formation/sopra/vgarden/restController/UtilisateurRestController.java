package formation.sopra.vgarden.restController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.vgarden.exceptions.UtilisateurException;
import formation.sopra.vgarden.model.Compte;
import formation.sopra.vgarden.model.Utilisateur;
import formation.sopra.vgarden.model.Views;
import formation.sopra.vgarden.services.CompteServices;
import formation.sopra.vgarden.services.UtilisateurServices;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurRestController {
	@Autowired
	UtilisateurServices utilisateurServices;
	@Autowired
	CompteServices compteServices;

	@GetMapping("/info")
	@JsonView(Views.Common.class)
	public Utilisateur getUtilisateur(@AuthenticationPrincipal Compte c) {
		return c.getUtilisateur();
	}
	
	
	@GetMapping("/{id}/terrain")
	@JsonView(Views.UtilisateurWithTerrains.class)
	public Utilisateur getByIdWithTerrain(@PathVariable Long id) {
		return utilisateurServices.getByIdWithTerrains(id);
	}
	

	// L'utilisation de update dans 'CompteRestController' effectue un save en cascade
	// du coup les modifications de l'utilisateur sont appliqués du coup cette méthode n'est pas nécessaire.
	@PutMapping("/{login}")
	@JsonView(Views.Common.class)
	public Utilisateur modifier(@PathVariable String login,@Valid @RequestBody Utilisateur u, BindingResult br) {
		Compte c = compteServices.getByLogin(login);
		if (br.hasErrors()) {
			throw new UtilisateurException("Données incorrectes");
		}
		return utilisateurServices.update(c, u);
	}

	@PutMapping("/upgrade")
	public Utilisateur upgrade(@AuthenticationPrincipal Compte c) {
//		if (br.hasErrors()) {
//			throw new UtilisateurException("Données incorrectes");
//		}
		return utilisateurServices.upgrade(c);
	}
}
