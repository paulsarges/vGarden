package vgarden.dao;

import vgarden.model.Commande;

public interface DaoCommande extends DaoGeneric<Commande, Long> {
    Commande findByIdWithCommandeProduits(Long id);
}
