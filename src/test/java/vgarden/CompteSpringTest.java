package vgarden;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import vgarden.config.AppConfig;
import vgarden.model.TypeCompte;
import vgarden.model.Utilisateur;
import vgarden.services.CompteServices;

@ContextConfiguration(classes = { AppConfig.class })
@ExtendWith(SpringExtension.class)
class CompteSpringTest {
	
	@Autowired
	CompteServices compteServices;

	@Test
	void CreateTest() {
		Utilisateur pro = new Utilisateur();
		pro.setLogin("pro1");
		pro.setPassword("proTest");
		pro.setTypeCompte(TypeCompte.Pro);
		compteServices.createOrUpdate(pro);		
	}
	
	@Test
	void checkCompteTest() {
		Utilisateur pro = new Utilisateur();
		pro.setLogin("pro1");
		pro.setPassword("proTest");
		pro.setTypeCompte(TypeCompte.Pro);
		compteServices.checkLogin(pro);
	}

}
