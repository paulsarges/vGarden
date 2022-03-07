package formation.sopra.vgarden.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "fiches_ravageur")
@SequenceGenerator(name = "seqFicheRavageur", sequenceName = "seq_fiche_ravageur", initialValue = 18, allocationSize = 1)
public class FicheRavageur {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFicheRavageur")
	@Column(name = "id")
	private Long id;

	@Column(name = "nom", length = 50, nullable = true)
	private String nom;

	@Column(name = "description", nullable = true)
	private String description;

	@Column(name = "solution", nullable = true)
	private String solution;

//	//A MODIF
//	@ManyToMany
//	@JoinTable(name="ravageurs",joinColumns = @JoinColumn(name="fiches_ravageurs_id",foreignKey = @ForeignKey(name="fiches_ravageurs_id_fk")),
//	inverseJoinColumns = @JoinColumn(name="plantes_id",foreignKey = @ForeignKey(name="plantes_id_fk")))
//	private List<FichePlante> plantes;

	public FicheRavageur(String nom, String description, String solution) {
		this.nom = nom;
		this.description = description;
		this.solution = solution;
	}

	public FicheRavageur() {

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

//	public List<FichePlante> getPlantes() {
//		return plantes;
//	}
//
//	public void setPlantes(List<FichePlante> plantes) {
//		this.plantes = plantes;
//	}

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
		FicheRavageur other = (FicheRavageur) obj;
		return Objects.equals(id, other.id);
	}







}
