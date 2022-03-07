package formation.sopra.vgarden.restController;

import com.fasterxml.jackson.annotation.JsonView;
import formation.sopra.vgarden.services.CommandeService;
import formation.sopra.vgarden.exceptions.CommandeException;
import formation.sopra.vgarden.model.Commande;
import formation.sopra.vgarden.model.Views;
import org.springframework.http.HttpStatus;
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

    @GetMapping("")
    @JsonView(Views.Common.class)
    public List<Commande> getAll() {
        return commandeService.getAll();
    }

    @GetMapping("/{commandeId}")
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
