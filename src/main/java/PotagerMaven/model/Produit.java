package PotagerMaven.model;

public class Produit {
	private Integer id;
	private String nom;
	private double stock;
	private double prix;
	// private Plante plante;
	
	public Produit(Integer id, String nom, double stock, double prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.stock = stock;
		this.prix = prix;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", stock=" + stock + ", prix=" + prix + "]";
	}
	

}
