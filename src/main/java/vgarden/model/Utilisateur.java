package vgarden.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "utilisateur")
public class Utilisateur extends Compte{
	
	private double taxe;
	private List<Commande> achats;
	private List<Commande> ventes;
	private List<Terrain> terrains;
	private List<Produit> produits;
	
	public Utilisateur() {
		super();
	}

	public double getTaxe() {
		return taxe;
	}

	public void setTaxe(double taxe) {
		this.taxe = taxe;
	}
	
	public List<Commande> getAchats() {
		return achats;
	}	

	public List<Commande> getVentes() {
		return ventes;
	}
	public void setAchats(List<Commande> achats) {
		this.achats = achats;
	}

	public void setVentes(List<Commande> ventes) {
		this.ventes = ventes;
	}

	public List<Terrain> getTerrains() {
		return terrains;
	}

	public List<Produit> getProduits() {
		return produits;
	}


	public void setTerrains(List<Terrain> terrains) {
		this.terrains = terrains;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public void acheter() {
		
	}
	
	public void vendre() {
		
	}
	
	public void afficherVente() {
		
	}
	
	public void modifierStockProduit() {
		
	}
	public void modifierPrixProduit(){
		
	}	
	
}
