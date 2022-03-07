package formation.sopra.vgarden.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.vgarden.model.Views;

import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "plante")
@SequenceGenerator(name = "seqPlantes", sequenceName = "seq_plantes", initialValue = 20, allocationSize = 1)
public class Plante {
	
	@JsonView(Views.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPlantes")
	@Column(name = "planteId")
	private long Id;
	@ManyToOne
	@JoinColumn(name = "planteTerrain", foreignKey = @ForeignKey(name = "plante_terrain_fk"))
	private Terrain terrain;
	@Embedded
	@Column(name = "planteEmplacement")
	private Emplacement emplacementPlante;
	@Enumerated(EnumType.STRING)
	@Column(name = "planteType")
	private TypePlante typePlante;
	@Column(name = "planteCroissance")
	private int croissance; //Entre 1 et 3 ?  - Determinera l'image de la plante (ou une barre de croissance).
	@Enumerated(EnumType.STRING)
	//@Column(name = "planteSolFavori")
	//private TypeDeSol solFavori; // A afficher sur la fiche de la plante.
	//@Column(name = "planteBesoinFixation")
	//private boolean besoinFixation; // Plantes montantes (tomates etc.)
	
	//@Column(name = "planteBesoinSemi")
	//private boolean besoinSemi; //
	//@Column(name = "planteDateRepiquage")
	//private LocalDate dateRepiquage; // Si besoin semi - A afficher sur l'appli � titre informatif dans la fiche de la plante.
	@Column(name = "planteDatePlantation")
	private LocalDate datePlantation; // A afficher dans la fiche de la plante
	@Column(name = "planteArrosageOk")
	private boolean arrosageOk; // Pour la notif d'arrosage.
	@Column(name = "planteDateRecolte")
	private LocalDate dateRecolte; //
	//@Column(name = "plante_DatePlantationOptimale")
	//private LocalDate datePlantationOptimale; // Pour conseiller l'utilisateur sur la date de plantation.
	//@Column(name = "plante_DateSemiOptimale")
	//private LocalDate dateSemiOptimale; // Pour conseiller l'utilisateur sur la date de mise en semi.
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public Terrain getTerrain() {
		return terrain;
	}
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
	public Emplacement getEmplacementPlante() {
		return emplacementPlante;
	}
	public void setEmplacementPlante(Emplacement emplacementPlante) {
		this.emplacementPlante = emplacementPlante;
	}
	public TypePlante getTypePlante() {
		return typePlante;
	}
	public void setTypePlante(TypePlante typePlante) {
		this.typePlante = typePlante;
	}
	public int getCroissance() {
		return croissance;
	}
	public void setCroissance(int croissance) {
		this.croissance = croissance;
	}
	public LocalDate getDatePlantation() {
		return datePlantation;
	}
	public void setDatePlantation(LocalDate datePlantation) {
		this.datePlantation = datePlantation;
	}
	public boolean isArrosageOk() {
		return arrosageOk;
	}
	public void setArrosageOk(boolean arrosageOk) {
		this.arrosageOk = arrosageOk;
	}
	public LocalDate getDateRecolte() {
		return dateRecolte;
	}
	public void setDateRecolte(LocalDate dateRecolte) {
		this.dateRecolte = dateRecolte;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plante other = (Plante) obj;
		return Id == other.Id;
	}




}
