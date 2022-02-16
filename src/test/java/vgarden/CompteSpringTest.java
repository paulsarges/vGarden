package vgarden;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import vgarden.model.TypeCompte;
import vgarden.model.Utilisateur;
import vgarden.services.CompteServices;

@ExtendWith(SpringExtension.class)
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
