package formation.sopra.vgarden.services;

import formation.sopra.vgarden.exceptions.CommandeException;
import formation.sopra.vgarden.model.Commande;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CommandeServiceTest {

    @Autowired
    private CommandeService commandeService;

    @Test
    @Transactional
    public void createFailMissingUtilisateur() {
        assertThrows(CommandeException.class, () -> {
            Commande commande = new Commande();
            commandeService.createOrUpdate(commande);
        });
    }
}
