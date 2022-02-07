package vgarden.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vgarden.exceptions.CompteException;
import vgarden.model.Compte;
import vgarden.repositories.CompteRepository;

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
			throw new CompteException("Données incorrectes");
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
