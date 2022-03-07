package formation.sopra.vgarden.restController;


import com.fasterxml.jackson.annotation.JsonView;
import formation.sopra.vgarden.exceptions.CompteException;
import formation.sopra.vgarden.model.Compte;
import formation.sopra.vgarden.model.Role;
import formation.sopra.vgarden.model.Views;
import formation.sopra.vgarden.repositories.CompteRepository;
import formation.sopra.vgarden.services.CompteServices;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class CompteRestController {

	private final CompteServices compteServices;
	private final CompteRepository compteRepo;
	private final PasswordEncoder passwordEncoder;

	public CompteRestController(CompteServices compteServices, CompteRepository compteRepo, PasswordEncoder passwordEncoder) {
		this.compteServices = compteServices;
		this.compteRepo = compteRepo;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping("")
	public void auth(@AuthenticationPrincipal Compte c ) {
		System.out.println(c.getUsername());
		System.out.println(c.getPassword());
		System.out.println(c.getRole());
	}

	/* REST EXEMPLE POUR CREATION COMPTE AVEC UTILISATEUR
	{
    	"login": "test3",
    	"password": "test3",
    	"utilisateur": {
        	"typeCompte": "Particulier"
        	// le reste des attributs nécessaires
    	}
	}
	 */

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

	@DeleteMapping("/suppression")
	public void deleteCompte(@AuthenticationPrincipal Compte c) {
		compteServices.delete(c);
	}

//	@PutMapping("/modifier/{username}")
//	@JsonView(Views.Common.class)
//	public Compte modifierPassword(@AuthenticationPrincipal Compte c, @RequestParam String username) {
//		return compteServices.updatePassword(c, username);
//	}

	// Test
	@PutMapping("")
    @JsonView(Views.Common.class)
    public Compte update(@AuthenticationPrincipal Compte c) {
		return compteServices.save(c);
	}

}
