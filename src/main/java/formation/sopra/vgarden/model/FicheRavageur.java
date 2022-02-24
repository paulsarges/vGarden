package formation.sopra.vgarden.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "fiche_ravageur")
@SequenceGenerator(name = "seqFicheRavageur", sequenceName = "seq_fiche_ravageur", initialValue = 1, allocationSize = 1)
public class FicheRavageur {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFicheRavageur")
	@Column(name = "id_fiche_ravageur")
	private Long id;
	
	@Column(name = "nom_fiche_ravageur", length = 50, nullable = false)
	private String nom;
	
	@Column(name = "description_fiche_ravageur", nullable = false)
	private String description;
	
	@Column(name = "solution_fiche_ravageur", nullable = false)
	private String solution;
	
	//A MODIF
	@ManyToMany
	@JoinTable(name="ravageurs",joinColumns = @JoinColumn(name="fiches_ravageurs_id",foreignKey = @ForeignKey(name="fiches_ravageurs_id_fk")),
	inverseJoinColumns = @JoinColumn(name="plantes_id",foreignKey = @ForeignKey(name="plantes_id_fk")))
	private List<FichePlante> plantes;

	public FicheRavageur(String nom, String description, String solution, List<FichePlante> plantes) {
		this.nom = nom;
		this.description = description;
		this.solution = solution;
		this.plantes = plantes;
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
		FicheRavageur other = (FicheRavageur) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
	
	
	
}
