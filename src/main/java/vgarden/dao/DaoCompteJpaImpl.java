package vgarden.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import vgarden.model.Compte;

public class DaoCompteJpaImpl implements DaoCompte{

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Compte> findAll() {
		return em.createQuery("from Compte d", Compte.class).getResultList();
	}

	@Override
	public Compte findByKey(Long key) {
		return em.find(Compte.class, key);
	}

	@Override
	@Transactional
	public void insert(Compte obj) {
		em.persist(obj);
	}

	@Override
	@Transactional
	public Compte update(Compte obj) {
		return em.merge(obj);
	}

	@Override
	@Transactional
	public void delete(Compte obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional
	public void deleteByKey(Long key) {
		em.remove(em.find(Compte.class, key));
	}
}
