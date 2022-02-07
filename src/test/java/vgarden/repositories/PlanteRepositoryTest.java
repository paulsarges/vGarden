package vgarden.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import vgarden.config.AppConfig;
import vgarden.model.Plante;
import vgarden.model.Terrain;
import vgarden.model.TypeDeSol;
import vgarden.model.TypePlante;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
class PlanteRepositoryTest {

	@Autowired
	PlanteRepository planteRepo;
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
		
		
		
		Plante plante = new Plante();
		plante.setBesoinFixation(true);
		plante.setTypePlante(TypePlante.Ail);
		plante.setDatePlantation(LocalDate.now());
		plante.setArrosageOk(true);
		plante.setTerrain(terrain);
		plante.setEmplacementPlante(null);
		
		
		
	}

}
