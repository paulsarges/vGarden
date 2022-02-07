package vgarden.services;

import org.springframework.stereotype.Service;
import vgarden.exceptions.CommandeException;
import vgarden.model.Commande;
import vgarden.repositories.CommandeProduitRepository;
import vgarden.repositories.CommandeRepository;

import java.util.List;

@Service
public class CommandeService {

    private final CommandeRepository commandeRepository;
    private final CommandeProduitRepository commandeProduitRepository;

    public CommandeService(CommandeRepository commandeRepository, CommandeProduitRepository commandeProduitRepository) {
        this.commandeRepository = commandeRepository;
        this.commandeProduitRepository = commandeProduitRepository;
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
}
