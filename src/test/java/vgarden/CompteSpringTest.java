package vgarden;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vgarden.model.TypeCompte;
import vgarden.model.Utilisateur;
import vgarden.services.CompteServices;

@SpringBootTest
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
