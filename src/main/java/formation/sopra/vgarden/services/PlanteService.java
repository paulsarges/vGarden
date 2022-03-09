package formation.sopra.vgarden.services;

import formation.sopra.vgarden.exceptions.PlanteException;
import formation.sopra.vgarden.model.Plante;
import formation.sopra.vgarden.model.Terrain;
import formation.sopra.vgarden.repositories.PlanteRepository;
import org.springframework.stereotype.Service;

import javax.validation.Validator;

import java.time.LocalDate;
import java.util.List;

@Service
public class PlanteService {

//	private static final Logger logger = LoggerFactory.getLogger(PlanteService.class);

    private final Validator validator;
    private final PlanteRepository planteRepository;

    public PlanteService(Validator validator, PlanteRepository planteRepository) {
        this.validator = validator;
        this.planteRepository = planteRepository;
        }

    public List<Plante> getByTerrain(Terrain terrain) {
    	return planteRepository.findByTerrain(terrain);
    }

    public Plante getById(Long id) {
    	return planteRepository.findById(id).orElseThrow(() -> {
            throw new PlanteException("Commande inexistante");
        });
    }

	public void delete(Plante plante) {
		planteRepository.delete(plante);
	}

	public void deleteById(Long id) {
		delete(getById(id));
	}

	public Plante createOrUpdate(Plante plante) {
		check(plante);
		if (plante.getId()==null) {
			plante.setDatePlantation(LocalDate.now());
			return planteRepository.save(plante);
		} else {
			Plante planteEnBase = getById(plante.getId());
			planteEnBase.setCroissance(plante.getCroissance());
			planteEnBase.setDateRecolte(plante.getDateRecolte());
			planteEnBase.setArrosageOk(plante.isArrosageOk());
			return planteRepository.save(planteEnBase);
		}
	}

	private void check(Plante plante) {
		if (!validator.validate(plante).isEmpty()) {
			throw new PlanteException();
		}
	}


	public boolean exist(Long id) {
		return planteRepository.existsById(id);
	}
}
