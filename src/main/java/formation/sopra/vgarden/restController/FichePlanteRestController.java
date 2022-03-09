package formation.sopra.vgarden.restController;

import com.fasterxml.jackson.annotation.JsonView;
import formation.sopra.vgarden.exceptions.FichePlanteException;
import formation.sopra.vgarden.model.FichePlante;
import formation.sopra.vgarden.model.Views;
import formation.sopra.vgarden.services.FichePlanteService;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/fiches_plante")
@CrossOrigin(origins = "*")
public class FichePlanteRestController {

    private final FichePlanteService fichePlanteService;

    public FichePlanteRestController(FichePlanteService fichePlanteService) {
        this.fichePlanteService = fichePlanteService;
    }

    @GetMapping("")
    @JsonView(Views.Common.class)
    public List<FichePlante> getAll() {
        return fichePlanteService.getAll();
    }

    @GetMapping("/{fichePlanteId}")
    @JsonView(Views.Common.class)
    public FichePlante getById(@PathVariable Long fichePlanteId) {
        return fichePlanteService.getById(fichePlanteId);
    }

    @PostMapping("")
    @JsonView(Views.Common.class)
    @ResponseStatus(code = HttpStatus.CREATED)
    public FichePlante create(@Valid @RequestBody FichePlante fichePlante, BindingResult result) {
        if(result.hasErrors()) {
            throw new FichePlanteException();
        }

        return fichePlanteService.save(fichePlante);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
    	fichePlanteService.delete(id);
    }
}
