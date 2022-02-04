package vgarden;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import vgarden.config.AppConfig;
import vgarden.model.Admin;
import vgarden.repositories.AdminRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
public class CompteRepositoryTest {
	@Autowired
	AdminRepository amdinRepo;

	
	@Test
	@Transactional
	void test() {
		Admin admin = new Admin();
		System.out.println(admin);
		admin.setLogin("test");
		admin.setPassword("test");
		
		amdinRepo.save(admin);
	}
}
