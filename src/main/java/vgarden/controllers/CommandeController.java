package vgarden.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vgarden.exceptions.CommandeException;
import vgarden.model.Commande;
import vgarden.model.CommandeProduit;
import vgarden.model.views.CommandeViews;
import vgarden.model.views.Views;
import vgarden.services.CommandeService;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

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
    public Set<CommandeProduit> getCommandeProduits(@PathVariable Long commandeId) {
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
