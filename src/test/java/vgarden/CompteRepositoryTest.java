package vgarden;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import vgarden.config.AppConfig;
import vgarden.model.Admin;
import vgarden.model.TypeCompte;
import vgarden.model.Utilisateur;
import vgarden.repositories.AdminRepository;
import vgarden.repositories.UtilisateurRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
public class CompteRepositoryTest {
	@Autowired
	AdminRepository amdinRepo;
	@Autowired
	UtilisateurRepository userRepo;

	
	@Test
	@Transactional
	@Commit
	void test() {
		Admin admin = new Admin();
		admin.setLogin("admin");
		admin.setPassword("admin");
		System.out.println("--------------------");
		System.out.println(admin);
		amdinRepo.save(admin);
		Utilisateur pro = new Utilisateur();
		pro.setLogin("test");
		pro.setPassword("test");
		pro.setTypeCompte(TypeCompte.Pro);
		userRepo.save(pro);
	}
}
 