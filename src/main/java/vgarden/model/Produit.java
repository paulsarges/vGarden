package vgarden.model;

import javax.persistence.*;

@Entity
@Table(name = "produit")
@SequenceGenerator(name = "seqProduit", sequenceName = "seq_produit", initialValue = 50, allocationSize = 1)
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProduit")
	@Column(name = "produit_id")
	private Long id;

	@Column(name = "produit_nom", length = 50, nullable = false)
	private String nom;
	private double stock;
	private double prix;
	// private Plante plante;

	public Produit() {

	}

	public Produit(String nom, double stock, double prix) {
		super();
		this.nom = nom;
		this.stock = stock;
		this.prix = prix;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
