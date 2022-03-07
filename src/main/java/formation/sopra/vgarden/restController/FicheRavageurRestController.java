package formation.sopra.vgarden.restController;

import com.fasterxml.jackson.annotation.JsonView;
import formation.sopra.vgarden.exceptions.FicheRavageurException;
import formation.sopra.vgarden.model.FicheRavageur;
import formation.sopra.vgarden.model.Views;
import formation.sopra.vgarden.services.FicheRavageurService;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/fiches_ravageurs")
public class FicheRavageurRestController {

    private final FicheRavageurService ficheRavageurService;

    public FicheRavageurRestController(FicheRavageurService ficheRavageurService) {
        this.ficheRavageurService = ficheRavageurService;
    }

    @GetMapping("")
    @JsonView(Views.Common.class)
    public List<FicheRavageur> getAll() {
        return ficheRavageurService.getAll();
    }

    @GetMapping("/{fiches_ravageur_id}")
    @JsonView(Views.Common.class)
    public FicheRavageur getById(@PathVariable Long ficheRavageurId) {
        return ficheRavageurService.getById(ficheRavageurId);
    }

    @PostMapping("")
    @JsonView(Views.Common.class)
    @ResponseStatus(code = HttpStatus.CREATED)
    public FicheRavageur create(@Valid @RequestBody FicheRavageur ficheRavageur, BindingResult result) {
        if(result.hasErrors()) {
            throw new FicheRavageurException();
        }

        return ficheRavageurService.save(ficheRavageur);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
    	ficheRavageurService.delete(id);
    }
}
