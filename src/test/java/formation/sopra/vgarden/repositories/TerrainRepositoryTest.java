package formation.sopra.vgarden.repositories;

import formation.sopra.vgarden.repositories.TerrainRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import formation.sopra.vgarden.model.Terrain;
import formation.sopra.vgarden.model.TypeDeSol;

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
