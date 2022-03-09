package formation.sopra.vgarden.services;


import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.vgarden.exceptions.ProduitException;
import formation.sopra.vgarden.exceptions.UtilisateurException;
import formation.sopra.vgarden.model.Compte;
import formation.sopra.vgarden.model.Produit;
import formation.sopra.vgarden.repositories.ProduitRepository;

@Service
public class ProduitService {
	
	@Autowired
	private ProduitRepository produitRepo;
	public ProduitService() {
	}
	
	public Produit getById(Long id) {
		return produitRepo.findById(id).orElseThrow(() ->
		new ProduitException("Erreur produit"));
	}
	
	public List<Produit> getAll(){
		return produitRepo.findAll();
	}
	
	public List<Produit> getByUtilisateur(Compte c) {
		return produitRepo.findByUtilisateur(c.getUtilisateur());
	}
	
	public Produit save(Compte compte, Produit produit) {
		produit.setUtilisateur(compte.getUtilisateur());
		return produitRepo.save(produit);
	}
	
	public Produit update(Produit produit) {
		Produit produitBase = produitRepo.findById(produit.getId()).orElseThrow(() ->
			new ProduitException("Erreur produit"));
		produitBase.setPrix(produit.getPrix());
		produitBase.setStock(produit.getStock());
		produitBase.setPlante(produit.getPlante());
		return produitRepo.save(produitBase);
	}
	
	
	public void delete(Long id) {
		produitRepo.deleteById(id);
	}

}
