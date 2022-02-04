package vgarden.model;

import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "utilisateur")
@SequenceGenerator(name = "seqCompte", sequenceName = "seq_utilisateur", initialValue = 100, allocationSize = 1)
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "utilsateur_id")),
					@AttributeOverride(name = "login", column = @Column(name = "utilsateur_login", length = 50, nullable = false)),
					@AttributeOverride(name = "password", column = @Column(name = "utilsateur_password", length = 50, nullable = false))
})
public class Utilisateur extends Compte{
	
	protected double taxe; 
	@Enumerated(EnumType.STRING)
	@Column(name = "civilite", length = 4)
	private Civilite civilite;
	@Embedded
	private Adresse adresse;
	@Enumerated(EnumType.STRING)
	@Column(name = "type_compte", length = 50)
	private TypeCompte typeCompte;
	@OneToMany(mappedBy = "acheteur")
	private Set<Commande> achats;
	@OneToMany(mappedBy = "vendeur")
	private Set<Commande> ventes;
	@Transient
	private List<Terrain> terrains;
	@Transient
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
	
	public Set<Commande> getAchats() {
		return achats;
	}	

	public Set<Commande> getVentes() {
		return ventes;
	}
	public void setAchats(Set<Commande> achats) {
		this.achats = achats;
	}

	public void setVentes(Set<Commande> ventes) {
		this.ventes = ventes;
	}

	public List<Terrain> getTerrains() {
		return terrains;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	
	public Adresse getAdresse() {
		return adresse;
	}

	
	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public void setTerrains(List<Terrain> terrains) {
		this.terrains = terrains;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	

	public TypeCompte getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(TypeCompte typeCompte) {
		this.typeCompte = typeCompte;
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
