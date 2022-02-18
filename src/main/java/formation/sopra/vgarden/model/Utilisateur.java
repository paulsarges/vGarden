package formation.sopra.vgarden.model;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@DiscriminatorValue(value = "utilisateur")
public class Utilisateur extends Compte{

	protected double taxe;
	@Enumerated(EnumType.STRING)
	@Column(name = "civilite", length = 4)
	private Civilite civilite;
	@Embedded
	private Adresse adresse;
	@Enumerated(EnumType.STRING)
	@Column(name = "type_compte", length = 50, nullable = false)
	private TypeCompte typeCompte;
	@OneToMany(mappedBy = "utilisateur")
	private Set<Commande> achats;
	// Pas besoin, une commande doit être associé à un produit qui lui même est associé à une plante qui
	// elle même est associé à un terrain qui lui doit être associé à un utilisateur
	//@OneToMany(mappedBy = "vendeur")
	//private Set<Commande> ventes;
	@OneToMany(mappedBy = "utilisateur")
	private List<Terrain> terrains;
	@Transient
	private List<Produit> produits;

	public Utilisateur() {
		super();
		this.role = Role.ROLE_USER;
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

	/*public Set<Commande> getVentes() {
		return ventes;
	}*/
	public void setAchats(Set<Commande> achats) {
		this.achats = achats;
	}

	/*public void setVentes(Set<Commande> ventes) {
		this.ventes = ventes;
	}*/

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
	


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new HashSet<GrantedAuthority>(Arrays.asList(new SimpleGrantedAuthority(this.role.toString())));
	}

	@Override
	public String getUsername() {
		return this.login;
	}
	
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
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
