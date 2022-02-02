package vgarden.model;

import java.util.List;

public class Commande {
	private Integer id;
	private Compte compte; // Seulement Particulier ?? (private Particulier compte)
	// JPA - @OneToMany
	private List<CommandeProduit> commandeProduits;
	
	/**
	 * Permet la création d'une commande.
	 * @param compte Le compte lié à la commande.
	 */
	public Commande(Compte compte) {
		super();
		this.compte = compte;
	}
	
	/**
	 * Constructeur de la commande.
	 * @param id - Id de la commande.
	 * @param compte - Le compte qui a passé la commande.
	 * @param commandeProduits - Les produits associés à la commande.
	 */
	public Commande(Integer id, Compte compte, List<CommandeProduit> commandeProduits) {
		super();
		this.id = id;
		this.compte = compte;
		this.commandeProduits = commandeProduits;
	}

	/**
	 * L'Id de la commande.
	 * @return Id de la commande.
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Recupère le compte qui a passé la commande.
	 * @return
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

	@Override
	public String toString() {
		return "Commande [id=" + id + ", compte=" + compte + ", commandeProduits=" + commandeProduits + "]";
	}

}
