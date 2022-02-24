package formation.sopra.vgarden.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.*;


@Entity
@Table(name = "fiche_maladie")
@SequenceGenerator(name = "seqFicheMaladie", sequenceName = "seq_fiche_maladie", initialValue = 1, allocationSize = 1)
public class FicheMaladie {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFicheMaladie")
	@Column(name = "id_fiche_maladie")
	private Long id;
	
	@Column(name = "nom_fiche_maladie", length = 50, nullable = false)
	private String nom;
	
	@Column(name = "description_fiche_maladie", nullable = false)
	private String description;
	
	@Column(name = "solution_fiche_maladie", nullable = false)
	private String solution;
	
	// A MODIF
	@ManyToMany
	@JoinTable(name="match",joinColumns = @JoinColumn(name="match_id_fiche_maladie",foreignKey = @ForeignKey(name="match_id_fiche_maladie_fk")),
	inverseJoinColumns = @JoinColumn(name="match_id_fiche_plante",foreignKey = @ForeignKey(name="match_id_fiche_plante_fk")))
	private List<FichePlante> plantes;

	public FicheMaladie() {
	
	}

	public FicheMaladie(String nom, String description, String solution, List<FichePlante> plantes) {
		this.nom = nom;
		this.description = description;
		this.solution = solution;
		this.plantes = plantes;
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

	public List<FichePlante> getPlantes() {
		return plantes;
	}

	public void setPlantes(List<FichePlante> plantes) {
		this.plantes = plantes;
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
		FicheMaladie other = (FicheMaladie) obj;
		return Objects.equals(id, other.id);
	}

	
}
