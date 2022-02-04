package vgarden.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedEntityGraph(name = "Commande.CommandeProduits",
		attributeNodes = @NamedAttributeNode("commandeProduits"))
@Table(name = "commande")
@SequenceGenerator(name = "seqCommande", sequenceName = "seq_commande", initialValue = 50, allocationSize = 1)
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCommande")
	@Column(name = "commande_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "commande_compte_id", foreignKey = @ForeignKey(name = "commande_compte_id_fk"))
	private Compte compte; // Seulement Particulier ?? (private Particulier compte)

	@ManyToOne
	@JoinColumn(name = "commande_vendeur_id_fk", foreignKey = @ForeignKey(name="commande_vendeur_id_fk"))
	private Utilisateur vendeur;
	
	@ManyToOne
	@JoinColumn(name = "commande_acheteur_id", foreignKey = @ForeignKey(name="commande_acheteur_id_fk"))
	private Utilisateur acheteur;
	
	@OneToMany(mappedBy = "id.commande")
	private List<CommandeProduit> commandeProduits;
 
	public Commande() {

	}

	/**
	 * Constructeur de la commande.
	 * @param compte - Le compte qui a passé la commande.
	 * @param commandeProduits - Les produits associés à la commande.
	 */
	public Commande(Compte compte, List<CommandeProduit> commandeProduits) {
		super();
		this.compte = compte;
		this.commandeProduits = commandeProduits;
	}

	/**
	 * L'Id de la commande.
	 * @return Id de la commande.
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Recupère le compte qui a passé la commande.
	 * @return le compte qui a passé la commande.
	 */
	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	/**
	 * Récupère les produits associés à la commande.
	 * @return Produits associés à la commande.
	 */
	public List<CommandeProduit> getCommandeProduits() {
		return commandeProduits;
	}

	public void setProduits(List<CommandeProduit> commandeProduits) {
		this.commandeProduits = commandeProduits;
	}

	/**
	 * Recupère le prix total de la commande
	 * par rapport au prix et à la quantité de chaque produit
	 * associé à la commande.
	 * @return Le prix total de la commande.
	 */
	public double prixTotal() {
		return commandeProduits
				.stream()
				.mapToDouble(commandeProduit -> commandeProduit.getId().getProduit().getPrix() * commandeProduit.getQuantite())
				.sum();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Commande commande = (Commande) o;
		return id.equals(commande.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
