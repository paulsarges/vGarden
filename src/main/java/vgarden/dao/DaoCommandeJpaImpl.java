package vgarden.dao;

import org.springframework.stereotype.Repository;
import vgarden.model.Commande;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DaoCommandeJpaImpl implements DaoCommande {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Commande> findAll() {
        TypedQuery<Commande> query = em.createQuery("from Commande c", Commande.class);
        return query.getResultList();
    }

    @Override
    public Commande findByKey(Long key) {
        return em.find(Commande.class, key);
    }

    @Override
    public void insert(Commande obj) {

    }

    @Override
    public Commande update(Commande obj) {
        return null;
    }

    @Override
    public void delete(Commande obj) {

    }

    @Override
    public void deleteByKey(Long key) {

    }

    @Override
    public Commande findByIdWithCommandeProduits(Long id) {
        TypedQuery<Commande> query = em.createQuery(
                "select commande from Commande commande left join fetch commande.commandeProduits where commande.id=:id", Commande.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
