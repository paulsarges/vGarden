package vgarden.repositories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import vgarden.model.Terrain;
import vgarden.model.TypeDeSol;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TerrainRepositoryTest {

	@Autowired
	TerrainRepository terrainRepo;

	@Test
	@Transactional
	@Commit
	void test() {
		Terrain terrain = new Terrain();
		terrain.setSurface(15.0);
		terrain.setDureeExpoSoleil(6.5);
		terrain.setTypeDeSol(TypeDeSol.Argileux);
		System.out.println("--------------------");
		System.out.println(terrain);
		terrainRepo.save(terrain);
		}
}
