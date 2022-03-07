package formation.sopra.vgarden.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@DiscriminatorValue(value = "utilisateur")
@SequenceGenerator(name = "utilisateurSeq", sequenceName = "utilisateur_seq", allocationSize = 1, initialValue = 100)
public class Utilisateur{
	@Id
	@GeneratedValue(generator = "utilisateurSeq", strategy = GenerationType.SEQUENCE)
	@JsonView(Views.Common.class)
	private Long id;
	@JsonView(Views.Common.class)
	protected double taxe;
	@Enumerated(EnumType.STRING)
	@Column(name = "civilite", length = 4)
	@JsonView(Views.Common.class)
	private Civilite civilite;
	@Embedded
	@JsonView(Views.Common.class)
	private Adresse adresse;
	@Enumerated(EnumType.STRING)
	@Column(name = "type_compte", length = 50, nullable = false)
	@JsonView(Views.Common.class)
	private TypeCompte typeCompte;
	@OneToMany(mappedBy = "utilisateur")
	private Set<Commande> achats;
	@OneToMany(mappedBy = "utilisateur")
	private List<Terrain> terrains;
	@Transient
	private List<Produit> produits;
	@OneToOne
	@JoinColumn(name = "compte_id", foreignKey = @ForeignKey(name = "compte_id_fk"))
	private Compte compte;
	@Version
	private int version;

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

	public void setAchats(Set<Commande> achats) {
		this.achats = achats;
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

	public Long getId() {
		return id;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		return Objects.equals(id, other.id);
	}

}
