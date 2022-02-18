package formation.sopra.vgarden.services;

import formation.sopra.vgarden.exceptions.CompteException;
import formation.sopra.vgarden.model.Compte;
import formation.sopra.vgarden.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteServices {
	@Autowired
	CompteRepository compteRepo;


	public Compte createOrUpdate(Compte c) {
		if (c == null) {
			throw new CompteException("Compte incorrecte");
		}
		if(c.getId() == null) {
			checkdata(c);
			return compteRepo.save(c);
		}
		else {
			Compte compteBase = compteRepo.getById(c.getId());
			if (compteBase.getLogin() == c.getLogin() && (compteBase.getPassword() != c.getPassword())) {
				checkdata(compteBase);
				compteBase.setPassword(c.getPassword());
			}
			return compteRepo.save(compteBase);
		}

	}

	public void checkdata(Compte c) {
		if (c.getLogin() == null ||c.getLogin().isEmpty()||c.getPassword() == null ||c.getPassword().isEmpty()) {
			throw new CompteException("Donn�es incorrectes");
		}
	}

	public Compte checkLogin(Compte c) {
		checkdata(c);
		String login = c.getLogin();
		String password = c.getPassword();
		Compte compteBase = compteRepo.findByloginAndPassWord(login, password).orElseThrow(CompteException::new);
		return compteBase;
	}
}
