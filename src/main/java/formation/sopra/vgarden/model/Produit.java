package formation.sopra.vgarden.model;

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

	@Column(name = "produit_stock", nullable = false)
	private double stock;

	@Column(name = "produit_prix", nullable = false)
	private double prix;

	@ManyToOne
	@JoinColumn(name = "produit_plante", foreignKey = @ForeignKey(name = "produit_plante_fk"))
	private Plante plante;

	public Produit() {

	}

	public Produit(String nom, double stock, double prix, Plante plante) {
		super();
		this.nom = nom;
		this.stock = stock;
		this.prix = prix;
		this.plante = plante;
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

	public Plante getPlante() {
		return plante;
	}

	public void setPlante(Plante plante) {
		this.plante = plante;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", stock=" + stock + ", prix=" + prix + "]";
	}

}
