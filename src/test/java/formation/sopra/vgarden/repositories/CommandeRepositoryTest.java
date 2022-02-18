package formation.sopra.vgarden.repositories;

import formation.sopra.vgarden.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CommandeRepositoryTest {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private CommandeProduitRepository commandeProduitRepository;

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private PlanteRepository planteRepository;

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private TerrainRepository terrainRepository;

    @Test
    @Transactional
    void findByIdAndFetchCommandeProduits() {
        Utilisateur particulier = new Utilisateur();
        particulier.setLogin("test");
        particulier.setPassword("test");
        particulier.setTypeCompte(TypeCompte.Particulier);

        Utilisateur pro = new Utilisateur();
        pro.setLogin("pro");
        pro.setPassword("pro");
        pro.setTypeCompte(TypeCompte.Pro);

        compteRepository.save(particulier);
        compteRepository.save(pro);

        Terrain terrain = new Terrain();
        terrain.setUtilisateur(pro);

        terrainRepository.save(terrain);

        Plante plante = new Plante();
        plante.setTypePlante(TypePlante.Ail);
        plante.setDatePlantation(LocalDate.now());
        plante.setEmplacementPlante(new Emplacement(1, 2));
        plante.setTerrain(terrain);

        planteRepository.save(plante);

        Produit produit = new Produit("test", 14, 12.50, plante);

        produitRepository.save(produit);

        Commande commande = new Commande(particulier);
        commande.addProduit(produit, 1);

        Commande savedCommande = commandeRepository.save(commande);

        Commande fetchedCommande = commandeRepository.findByIdWithCommandeProduits(savedCommande.getId()).orElse(null);

        assertNotNull(fetchedCommande);
        assertNotNull(fetchedCommande.getCommandeProduits());
    }
}
