package formation.sopra.vgarden.restController;

import com.fasterxml.jackson.annotation.JsonView;
import formation.sopra.vgarden.exceptions.CommandeException;
import formation.sopra.vgarden.model.Commande;
import formation.sopra.vgarden.model.Compte;
import formation.sopra.vgarden.model.Views;
import formation.sopra.vgarden.services.CommandeService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/commande")
public class CommandeRestController {

    private final CommandeService commandeService;

    public CommandeRestController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    /*@GetMapping("")
    @JsonView(Views.Common.class)
    public List<Commande> getAll() {
        return commandeService.getAll();
    }*/

    @GetMapping("/achat")
    @JsonView(Views.CommandeWithCommandeProduits.class)
    public List<Commande> getAllAchat(@AuthenticationPrincipal Compte c) {
        return commandeService.getByUtilisateurAchatWithCommandeProduits(c.getUtilisateur());
    }

    @GetMapping("/vente")
    @JsonView(Views.CommandeWithCommandeProduits.class)
    public List<Commande> getAllVente(@AuthenticationPrincipal Compte c) {
        return commandeService.getByUtilisateurVenteWithCommandeProduits(c.getUtilisateur());
    }

    @GetMapping("/id/{commandeId}")
    @JsonView(Views.CommandeWithCommandeProduits.class)
    public Commande getById(@PathVariable Long commandeId) {
        return commandeService.getByIdWithCommandeProduits(commandeId);
    }

    /*@GetMapping("/{commandeId}/produits")
    @JsonView(Views.CommandeWithCommandeProduits.class)
    public Commande getByIdWithCommandeProduits(@PathVariable Long commandeId) {
        return commandeService.getByIdWithCommandeProduits(commandeId);
    }*/

    @PostMapping("")
    @JsonView(Views.Common.class)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Commande create(@Valid @RequestBody Commande commande, BindingResult result) {
        if(result.hasErrors()) {
            throw new CommandeException();
        }

        return commandeService.createOrUpdate(commande);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        commandeService.deleteById(id);
    }
}
