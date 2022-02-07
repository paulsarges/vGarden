package vgarden.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
/*@NamedEntityGraph(name = "Commande.CommandeProduits",
		attributeNodes = @NamedAttributeNode("commandeProduits"))*/
@Table(name = "commande")
@SequenceGenerator(name = "seqCommande", sequenceName = "seq_commande", initialValue = 50, allocationSize = 1)
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCommande")
	@Column(name = "commande_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "commande_utilisateur_id", foreignKey = @ForeignKey(name = "commande_compte_id_fk"))
	private Utilisateur utilisateur;

	@Column(name = "commande_date_creation", nullable = false)
	private LocalDate dateCreation;

	@OneToMany(mappedBy = "id.commande")
	private Set<CommandeProduit> commandeProduits;

	public Commande() {

	}

	/**
	 * Constructeur de la commande.
	 * @param utilisateur - L'utilisateur qui a passé la commande.
	 */
	public Commande(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
		this.dateCreation = LocalDate.now();
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
	 * Recupère l'utilisateur qui a passé la commande.
	 * @return l'utilisateur qui a passé la commande.
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	/**
	 * Récupère les produits associés à la commande.
	 * @return Produits associés à la commande.
	 */
	public Set<CommandeProduit> getCommandeProduits() {
		return commandeProduits;
	}

	public void setCommandeProduits(Set<CommandeProduit> commandeProduits) {
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
