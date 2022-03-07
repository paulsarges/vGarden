package formation.sopra.vgarden.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.vgarden.exceptions.PlanteException;
import formation.sopra.vgarden.model.Plante;
import formation.sopra.vgarden.model.Terrain;
import formation.sopra.vgarden.model.Views;
import formation.sopra.vgarden.services.PlanteService;

@RestController
@RequestMapping("/plante")
@CrossOrigin(origins = "*")
public class PlanteRestController {

	@Autowired
	private PlanteService planteService;

	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Plante> getByTerrain(@PathVariable Terrain terrain) {
		List<Plante> list = planteService.getByTerrain(terrain);
		System.out.println(list);
		return list;
	}

//	@GetMapping("/get")
//	@JsonView(Views.Common.class)
//	public Plante getById(@RequestParam Long id) {
//		return planteService.getById(id);
//	}

	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Plante getById(@PathVariable Long id) {
		return planteService.getById(id);
	}

	//@GetMapping("/{id}/plante")
	//@JsonView(Views.PlanteWithEmploye.class)
	//public Plante getByIdWithEmploye(@PathVariable Long id) {
	//	return planteService.getByIdWithEmployes(id);
	//}

	@PostMapping("")
	@JsonView(Views.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Plante create(@Valid @RequestBody Plante plante, BindingResult br) {
		if (br.hasErrors()) {
			throw new PlanteException("Plante mal créée");
		}
		return planteService.createOrUpdate(plante);
	}
	//{"terrain":{"id":"2"},
	//	"emplacementPlante": 
	//	{"positionx":"2",
	//	"positiony":"2"},
	//	"typePlante": "Carotte"}
	
	
	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public Plante update(@PathVariable Long id, @Valid @RequestBody Plante plante, BindingResult br) {
		if (plante.getId() == 0L || id != plante.getId() || br.hasErrors()) {
			throw new PlanteException();
		}
		return planteService.createOrUpdate(plante);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		planteService.deleteById(id);
	}

}
