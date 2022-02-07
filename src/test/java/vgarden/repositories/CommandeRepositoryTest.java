package vgarden.repositories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import vgarden.config.AppConfig;
import vgarden.model.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
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

    @Test
    @Transactional
    void findByIdAndFetchCommandeProduits() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setLogin("test");
        utilisateur.setPassword("test");
        utilisateur.setTypeCompte(TypeCompte.Particulier);

        compteRepository.save(utilisateur);

        Plante plante = new Plante();
        plante.setTypePlante(TypePlante.Ail);
        plante.setDatePlantation(LocalDate.now());

        planteRepository.save(plante);

        Produit produit = new Produit("test", 14, 12.50, plante);

        produitRepository.save(produit);

        Commande commande = new Commande(utilisateur);

        commandeRepository.save(commande);

        commandeProduitRepository.save(new CommandeProduit(commande, produit, 1));

        Commande fetchedCommande = commandeRepository.findByIdWithCommandeProduits(50L).orElse(null);

        assertNotNull(fetchedCommande);
        // assertNotNull(fetchedCommande.getCommandeProduits());
    }
}
