package formation.sopra.vgarden.restController;

import com.fasterxml.jackson.annotation.JsonView;
import formation.sopra.vgarden.exceptions.FicheMaladieException;
import formation.sopra.vgarden.model.FicheMaladie;
import formation.sopra.vgarden.model.Views;
import formation.sopra.vgarden.services.FicheMaladieService;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/fiches_maladie")
public class FicheMaladieRestController {

    private final FicheMaladieService ficheMaladieService;

    public FicheMaladieRestController(FicheMaladieService ficheMaladieService) {
        this.ficheMaladieService = ficheMaladieService;
    }

    @GetMapping("")
    @JsonView(Views.Common.class)
    public List<FicheMaladie> getAll() {
        return ficheMaladieService.getAll();
    }

    @GetMapping("/{fiches_maladie_id}")
    @JsonView(Views.Common.class)
    public FicheMaladie getById(@PathVariable Long ficheMaladieId) {
        return ficheMaladieService.getById(ficheMaladieId);
    }

    @PostMapping("")
    @JsonView(Views.Common.class)
    @ResponseStatus(code = HttpStatus.CREATED)
    public FicheMaladie create(@Valid @RequestBody FicheMaladie ficheMaladie, BindingResult result) {
        if(result.hasErrors()) {
            throw new FicheMaladieException();
        }

        return ficheMaladieService.save(ficheMaladie);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
    	ficheMaladieService.delete(id);
    }
}
