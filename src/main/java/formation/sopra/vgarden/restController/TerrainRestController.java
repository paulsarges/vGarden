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

import formation.sopra.vgarden.exceptions.TerrainException;
import formation.sopra.vgarden.model.Terrain;
import formation.sopra.vgarden.model.Utilisateur;
import formation.sopra.vgarden.model.Views;
import formation.sopra.vgarden.services.TerrainService;

	@RestController
	@RequestMapping("/terrain")
	@CrossOrigin(origins = "*")
	public class TerrainRestController {

		@Autowired
		private TerrainService terrainService;

		@GetMapping("")
		@JsonView(Views.Common.class)
		public List<Terrain> getByUtilisateur(@PathVariable Utilisateur utilisateur) {
			List<Terrain> list = terrainService.getByUtilisateur(utilisateur);
			System.out.println(list);
			return list;
		}

//		@GetMapping("/get")
//		@JsonView(Views.Common.class)
//		public Terrain getById(@RequestParam Long id) {
//			return terrainService.getById(id);
//		}

		@GetMapping("/{id}")
		@JsonView(Views.Common.class)
		public Terrain getById(@PathVariable Long id) {
			return terrainService.getById(id);
		}

		//@GetMapping("/{id}/terrain")
		//@JsonView(Views.TerrainWithEmploye.class)
		//public Terrain getByIdWithEmploye(@PathVariable Long id) {
		//	return terrainService.getByIdWithEmployes(id);
		//}

		@PostMapping("")
		@JsonView(Views.Common.class)
		@ResponseStatus(code = HttpStatus.CREATED)
		public Terrain create(@Valid @RequestBody Terrain terrain, BindingResult br) {
			if (br.hasErrors()) {
				throw new TerrainException();
			}
			return terrainService.createOrUpdate(terrain);
		}
		
		// {
		//	"surface":"20",
		//	"localisation":"Montluçon",
		//	"utilisateur": {"id":"100"}
		//	}

		@PutMapping("/{id}")
		@JsonView(Views.Common.class)
		public Terrain update(@PathVariable Long id, @Valid @RequestBody Terrain terrain, BindingResult br) {
			if (terrain.getId() == null|| id != terrain.getId() || br.hasErrors()) {
				throw new TerrainException();
			}
			return terrainService.createOrUpdate(terrain);
		}

		@DeleteMapping("/{id}")
		@ResponseStatus(code = HttpStatus.NO_CONTENT)
		public void delete(@PathVariable Long id) {
			terrainService.deleteById(id);
		}

}
