package formation.sopra.vgarden.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import formation.sopra.vgarden.exceptions.CommandeException;
import formation.sopra.vgarden.model.Commande;
import formation.sopra.vgarden.model.CommandeProduit;
import formation.sopra.vgarden.model.Views;
import formation.sopra.vgarden.services.CommandeService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/commande")
public class CommandeController {

    private final CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping("")
    @JsonView(Views.Common.class)
    public List<Commande> getAll() {
        return commandeService.getAll();
    }

    @GetMapping("{commandeId}/produits")
    @JsonView(CommandeViews.WithCommandeProduits.class)
    public List<CommandeProduit> getCommandeProduits(@PathVariable Long commandeId) {
        return commandeService.getByIdWithCommandeProduits(commandeId).getCommandeProduits();
    }

    @PostMapping("")
    @JsonView(Views.Common.class)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Commande create(@Valid @RequestBody Commande commande, BindingResult result) {
        if(result.hasErrors()) {
            throw new CommandeException();
        }

        return commandeService.createOrUpdate(commande);
    }
}
