package formation.sopra.vgarden.services;

import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.vgarden.exceptions.FichePlanteException;
import formation.sopra.vgarden.model.FichePlante;
import formation.sopra.vgarden.repositories.FichePlanteRepository;

@Service
public class FichePlanteService {
	@Autowired
	private FichePlanteRepository fichePlanteRepo;
	@Autowired
	private Validator validator;

	public List<FichePlante> getAll() {
		return fichePlanteRepo.findAll();
	}

	public FichePlante getById(Long id) {
		return fichePlanteRepo.findById(id).orElseThrow(FichePlanteException::new);
	}

	public void delete(FichePlante fichePlante) {
		fichePlanteRepo.delete(fichePlante);
	}

	public void delete(Long id) {
		delete(getById(id));
	}

	public FichePlante save(FichePlante fichePlante) {
		check(fichePlante);
		if (fichePlante.getId() == null) {
			return fichePlanteRepo.save(fichePlante);
		} else {
			FichePlante fichePlanteEnBase = getById(fichePlante.getId());
			fichePlanteEnBase.setNom(fichePlante.getNom());
			fichePlanteEnBase.setEau(fichePlante.getEau());
			fichePlanteEnBase.setExposition(fichePlante.getExposition());
			fichePlanteEnBase.setEspacement(fichePlante.getEspacement());
			fichePlanteEnBase.setDureeConservationGraine(fichePlante.getDureeConservationGraine());
			fichePlanteEnBase.setCalendrierSemer(fichePlante.getCalendrierSemer());
			fichePlanteEnBase.setCalendrierPlanter(fichePlante.getCalendrierPlanter());
			fichePlanteEnBase.setCalendrierRecolter(fichePlante.getCalendrierRecolter());
			fichePlanteEnBase.setBonsCopains(fichePlante.getBonsCopains());
			fichePlanteEnBase.setMauvaisCopains(fichePlante.getMauvaisCopains());
			fichePlanteEnBase.setMaladies(fichePlante.getMaladies());
			fichePlanteEnBase.setRavageurs(fichePlante.getRavageurs());
			fichePlanteEnBase.setMethodeSemer(fichePlante.getMethodeSemer());
			fichePlanteEnBase.setMethodePlanter(fichePlante.getMethodePlanter());
			fichePlanteEnBase.setMethodeEntretien(fichePlante.getMethodeEntretien());
			fichePlanteEnBase.setMethodeRecolte(fichePlante.getMethodeRecolte());
			return fichePlanteRepo.save(fichePlanteEnBase);
		}
	}

	private void check(FichePlante fichePlante) {
		if (!validator.validate(fichePlante).isEmpty()) {
			throw new FichePlanteException();
		}
	}

	public boolean exist(Long id) {
		return fichePlanteRepo.existsById(id);
	}
}
