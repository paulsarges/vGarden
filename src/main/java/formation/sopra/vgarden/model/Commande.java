package formation.sopra.vgarden.model;

import com.fasterxml.jackson.annotation.JsonView;
import formation.sopra.vgarden.model.views.CommandeViews;
import formation.sopra.vgarden.model.views.Views;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
/*@NamedEntityGraph(name = "Commande.CommandeProduits",
		attributeNodes = @NamedAttributeNode("commandeProduits"))*/
@Table(name = "commande")
@SequenceGenerator(name = "seqCommande", sequenceName = "seq_commande", initialValue = 50, allocationSize = 1)
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCommande")
	@Column(name = "commande_id")
	@JsonView(Views.Common.class)
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "commande_utilisateur_id", foreignKey = @ForeignKey(name = "commande_compte_id_fk"), nullable = false)
	@JsonView(CommandeViews.WithUtilisateur.class)
	private Utilisateur utilisateur;

	@Column(name = "commande_date_creation", nullable = false)
	@JsonView(Views.Common.class)
	private LocalDateTime dateCreation;

	@OneToMany(mappedBy = "id.commande", cascade = CascadeType.REMOVE)
	@JsonView(CommandeViews.WithCommandeProduits.class)
	private List<CommandeProduit> commandeProduits = new ArrayList<>();

	@Version
	private int version;

	/**
	 * Constructeur vide par défaut.
	 */
	public Commande() {
		this.dateCreation = LocalDateTime.now();
	}

	/**
	 * Constructeur de la commande.
	 * @param utilisateur - L'utilisateur qui a passé la commande.
	 */
	public Commande(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
		this.dateCreation = LocalDateTime.now();
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
	 * @return - l'utilisateur qui a passé la commande.
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	/**
	 * La date de la création de la commande.
	 * @return - Date de création de la commande
	 */
	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	/**
	 * Récupère les produits associés à la commande.
	 * @return Produits associés à la commande.
	 */
	public List<CommandeProduit> getCommandeProduits() {
		return commandeProduits;
	}

	public void setCommandeProduits(List<CommandeProduit> commandeProduits) {
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

	/**
	 * Permet d'ajout un produit à la commande
	 * @param produit - Le produit à ajouter
	 * @param quantite - La quantité du produit
	 */
	public void addProduit(Produit produit, int quantite) {
		commandeProduits.add(new CommandeProduit(this, produit, quantite));
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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
