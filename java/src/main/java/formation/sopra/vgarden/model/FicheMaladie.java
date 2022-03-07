package formation.sopra.vgarden.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.*;


@Entity
@Table(name = "fiches_maladie")
@SequenceGenerator(name = "seqFicheMaladie", sequenceName = "seq_fiche_maladie", initialValue = 14, allocationSize = 1)
public class FicheMaladie {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFicheMaladie")
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nom", length = 50, nullable = true)
	private String nom;
	
	@Column(name = "description", nullable = true)
	private String description;
	
	@Column(name = "solution", nullable = true)
	private String solution;

	public FicheMaladie() {
	
	}

	public FicheMaladie(String nom, String description, String solution) {
		this.nom = nom;
		this.description = description;
		this.solution = solution;
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
