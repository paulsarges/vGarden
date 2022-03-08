package formation.sopra.vgarden.services;

import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import formation.sopra.vgarden.exceptions.FicheMaladieException;
import formation.sopra.vgarden.model.FicheMaladie;
import formation.sopra.vgarden.repositories.FicheMaladieRepository;

@Service
public class FicheMaladieService {
	@Autowired
	private FicheMaladieRepository maladieRepo;
	@Autowired
	private Validator validator;

	public List<FicheMaladie> getAll() {
		return maladieRepo.findAll(Sort.by(Sort.Order.asc("id")));
	}

	public FicheMaladie getById(Long id) {
		return maladieRepo.findById(id).orElseThrow(FicheMaladieException::new);
	}

	public void delete(FicheMaladie ficheMaladie) {
		maladieRepo.delete(ficheMaladie);
	}

	public void delete(Long id) {
		delete(getById(id));
	}

	public FicheMaladie save(FicheMaladie ficheMaladie) {
		check(ficheMaladie);
		if (ficheMaladie.getId() == null) {
			return maladieRepo.save(ficheMaladie);
		} else {
			FicheMaladie ficheMaladieEnBase = getById(ficheMaladie.getId());
			ficheMaladieEnBase.setNom(ficheMaladie.getNom());
			ficheMaladieEnBase.setDescription(ficheMaladie.getDescription());
			ficheMaladieEnBase.setSolution(ficheMaladie.getSolution());
			return maladieRepo.save(ficheMaladieEnBase);
		}
	}

	private void check(FicheMaladie ficheMaladie) {
		if (!validator.validate(ficheMaladie).isEmpty()) {
			throw new FicheMaladieException();
		}
	}

	public boolean exist(Long id) {
		return maladieRepo.existsById(id);
	}
}
