package vgarden.services;

import org.springframework.stereotype.Service;
import vgarden.exceptions.CommandeException;
import vgarden.model.Commande;
import vgarden.repositories.CommandeRepository;

import javax.validation.Validator;
import java.util.List;

@Service
public class CommandeService {

    private final Validator validator;
    private final CommandeRepository commandeRepository;

    public CommandeService(Validator validator, CommandeRepository commandeRepository) {
        this.validator = validator;
        this.commandeRepository = commandeRepository;
    }

    public List<Commande> getAll() {
        return commandeRepository.findAll();
    }

    public Commande getById(Long id) {
        return commandeRepository.findById(id).orElseThrow(() -> {
            throw new CommandeException("Commande inexistante");
        });
    }

    public Commande getByIdWithCommandeProduits(Long id) {
        return commandeRepository.findByIdWithCommandeProduits(id).orElseThrow(() -> {
            throw new CommandeException("Commande inexistante");
        });
    }

    public Commande createOrUpdate(Commande commande) {
        if (commande == null) {
            throw new CommandeException();
        }

        checkData(commande);

        if (commande.getId() == null) {
            return commandeRepository.save(commande);
        } else {
            Commande databaseCommande = getById(commande.getId());
            databaseCommande.setCommandeProduits(commande.getCommandeProduits());
            return commandeRepository.save(databaseCommande);
        }
    }

    private void checkData(Commande commande) {
        if(!validator.validate(commande).isEmpty()) {
            throw new CommandeException();
        }
    }

    public void delete(Commande commande) {
        if (commande == null || commande.getId() == null) {
            throw new CommandeException();
        }

        Commande databaseCommande = getById(commande.getId());

        commandeRepository.delete(databaseCommande);
    }

    public void deleteById(Long id) {
        delete(getById(id));
    }
}
