package vgarden.model;

import java.util.List;

public class Utilisateur extends Compte{
	
	private double taxe;
	private List<Commande> commandes;
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
	
	
	public List<Commande> getCommandes() {
		return commandes;
	}

	public List<Terrain> getTerrains() {
		return terrains;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
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
