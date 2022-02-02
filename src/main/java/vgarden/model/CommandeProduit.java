package vgarden.model;

public class CommandeProduit {
	private Integer id;
	private Produit produit;
	private Integer quantite;
	// JPA - @ManyToOne
	private transient Commande commande;
	
	/**
	 * Permet l'ajout d'un produit à une commande
	 * @param produit Produit à ajouté à la commande
	 * @param quantite La quantité voulue du produit à commander
	 * @param commande La commande associée
	 */
	public CommandeProduit(Produit produit, Integer quantite, Commande commande) {
		super();
		this.produit = produit;
		this.quantite = quantite;
		this.commande = commande;
	}
	
	public CommandeProduit(Integer id, Produit produit, Integer quantite, Commande commande) {
		super();
		this.id = id;
		this.produit = produit;
		this.quantite = quantite;
		this.commande = commande;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Récupère le produit de la commande
	 * @return {@link Produit produit} de la commande
	 */
	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	/**
	 * Récupère la quantité du produit dans la commande
	 * @return La quantité du produit
	 */
	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	/**
	 * Récupère la commande associée
	 * @return {@link Commande commande} associée
	 */
	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	@Override
	public String toString() {
		return "CommandeProduit [id=" + id + ", produit=" + produit + ", quantite=" + quantite + "]";
	}

}
