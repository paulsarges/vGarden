package vgarden.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import vgarden.config.AppConfig;
import vgarden.model.Emplacement;
import vgarden.model.Plante;
import vgarden.model.Terrain;
import vgarden.model.TypeCompte;
import vgarden.model.TypeDeSol;
import vgarden.model.TypePlante;
import vgarden.model.Utilisateur;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
class PlanteRepositoryTest {

	@Autowired
	PlanteRepository planteRepo;
	@Autowired
	TerrainRepository terrainRepo;
	@Autowired
	CompteRepository compteRepo;
	@Test
	@Transactional
	@Commit
	
	void test() {
		
		Plante plante = new Plante();
		plante.setBesoinFixation(true);
		plante.setTypePlante(TypePlante.Ail);
		plante.setDatePlantation(LocalDate.now());
		plante.setArrosageOk(true);
		Emplacement emplacement = new Emplacement(2,2);
		plante.setEmplacementPlante(emplacement);
		
		Terrain terrain = new Terrain();
		terrain.setSurface(15.0);
		terrain.setDureeExpoSoleil(6.5);
		terrain.setTypeDeSol(TypeDeSol.Argileux);
		System.out.println("--------------------");
		System.out.println(terrain);
		
		
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setTypeCompte(TypeCompte.Pro);
		List<Terrain> terrains = new ArrayList<Terrain>();
		utilisateur.setTerrains(terrains);
		
		plante.setTerrain(terrain);
		//List <Terrain> terrains = new ArrayList<Terrain>();
		//terrains.add(terrain);
		
		utilisateur.getTerrains().add(terrain);
		
		System.out.println("--------------------");
		System.out.println(plante);
		System.out.println("--------------------");
		System.out.println(utilisateur);
		compteRepo.save(utilisateur);
		
		planteRepo.save(plante);
		terrainRepo.save(terrain);
		
	}

}
