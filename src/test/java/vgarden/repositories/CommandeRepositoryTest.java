package vgarden.repositories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import vgarden.config.AppConfig;
import vgarden.model.*;

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
    private CompteRepository compteRepository;

    @Test
    @Transactional
    @Commit
    void findByIdAndFetchCommandeProduits() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setLogin("test");
        utilisateur.setPassword("test");

        compteRepository.save(utilisateur);

        Produit produit = new Produit("test", 14, 12.50);

        produitRepository.save(produit);

        Commande commande = new Commande();
        commande.setUtilisateur(utilisateur);

        commandeRepository.save(commande);

        commandeProduitRepository.save(new CommandeProduit(new CommandeProduitKey(commande, produit), 1));

        System.out.println(commandeRepository.findByIdFetchCommandeProduits(50L));
    }
}
