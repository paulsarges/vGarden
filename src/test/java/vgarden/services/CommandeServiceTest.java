package vgarden.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import vgarden.config.AppConfig;
import vgarden.exceptions.CommandeException;
import vgarden.model.Commande;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
class CommandeServiceTest {

    @Autowired
    private CommandeService commandeService;

    @Test
    @Transactional
    public void createOrUpdateMissingUser() {
        assertThrows(CommandeException.class, () -> {
            Commande commande = new Commande();
            commandeService.createOrUpdate(commande);
        });
    }
}
