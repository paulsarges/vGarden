package formation.sopra.vgarden.model;

import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "fiche_plante")
@SequenceGenerator(name = "seqFichePlante", sequenceName = "seq_fiche_plante", initialValue = 1, allocationSize = 1)
public class FichePlante {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFichePlante")
	@Column(name = "id_fiche_plante")
	private Long id;
	
	@Column(name = "nom_fiche_plante", length = 50, nullable = false)
	private String nom;
	
	@Column(name = "eau_fiche_maladie", nullable = false)
	private String eau;
	
	@Column(name = "exposition_fiche_maladie", nullable = false)
	private String exposition;
	
	@Column(name = "exposition_fiche_maladie", nullable = false)
	private String espacement;
	
	@Column(name = "conservation_graine_fiche_maladie", nullable = false)
	private String dureeConservationGraine;
	
	
	@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass = Month.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "calendrier_semer")
	private Set<Month> calendrierSemer;
	
	@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass = Month.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "calendrier_planter")
	private Set<Month> calendrierPlanter;
	
	@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass = Month.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "calendrier_recolter")
	private Set<Month> calendrierRecolter;
	
	@OneToMany(mappedBy = "bonsCopains")
	private List<FichePlante> bonsCopains;
	
	@OneToMany(mappedBy = "mauvaisCopains")
	private List<FichePlante> mauvaisCopains;
	
	@ManyToMany(mappedBy = "maladiesDeLaPlante")
	private List<FicheMaladie> maladiesPlante;
	
	@ManyToMany(mappedBy = "ravageursDeLaPlante")
	private List<FicheRavageur> ravageursPlante;
	
	@Column(name = "methodeSemer_fiche_maladie", nullable = true)
	private String methodeSemer;
	
	@Column(name = "methodePlanter_fiche_maladie", nullable = true)
	private String methodePlanter;
	
	@Column(name = "methodeEntretien_fiche_maladie", nullable = true)
	private String methodeEntretien;
	
	@Column(name = "methodeRecolte_fiche_maladie", nullable = true)
	private String methodeRecolte;
	
	public FichePlante() {
		
	}

	public FichePlante(String nom, String eau, String exposition, String espacement, String dureeConservationGraine,
			Set<Month> calendrierSemer, Set<Month> calendrierPlanter, Set<Month> calendrierRecolter,
			List<FichePlante> bonsCopains, List<FichePlante> mauvaisCopains, List<FicheMaladie> maladiesPlante,
			List<FicheRavageur> ravageursPlante, String methodeSemer, String methodePlanter, String methodeEntretien,
			String methodeRecolte) {
	
		this.nom = nom;
		this.eau = eau;
		this.exposition = exposition;
		this.espacement = espacement;
		this.dureeConservationGraine = dureeConservationGraine;
		this.calendrierSemer = calendrierSemer;
		this.calendrierPlanter = calendrierPlanter;
		this.calendrierRecolter = calendrierRecolter;
		this.bonsCopains = bonsCopains;
		this.mauvaisCopains = mauvaisCopains;
		this.maladiesPlante = maladiesPlante;
		this.ravageursPlante = ravageursPlante;
		this.methodeSemer = methodeSemer;
		this.methodePlanter = methodePlanter;
		this.methodeEntretien = methodeEntretien;
		this.methodeRecolte = methodeRecolte;
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

	public String getEau() {
		return eau;
	}

	public void setEau(String eau) {
		this.eau = eau;
	}

	public String getExposition() {
		return exposition;
	}

	public void setExposition(String exposition) {
		this.exposition = exposition;
	}

	public String getEspacement() {
		return espacement;
	}

	public void setEspacement(String espacement) {
		this.espacement = espacement;
	}

	public String getDureeConservationGraine() {
		return dureeConservationGraine;
	}

	public void setDureeConservationGraine(String dureeConservationGraine) {
		this.dureeConservationGraine = dureeConservationGraine;
	}

	public Set<Month> getCalendrierSemer() {
		return calendrierSemer;
	}

	public void setCalendrierSemer(Set<Month> calendrierSemer) {
		this.calendrierSemer = calendrierSemer;
	}

	public Set<Month> getCalendrierPlanter() {
		return calendrierPlanter;
	}

	public void setCalendrierPlanter(Set<Month> calendrierPlanter) {
		this.calendrierPlanter = calendrierPlanter;
	}

	public Set<Month> getCalendrierRecolter() {
		return calendrierRecolter;
	}

	public void setCalendrierRecolter(Set<Month> calendrierRecolter) {
		this.calendrierRecolter = calendrierRecolter;
	}

	public List<FichePlante> getBonsCopains() {
		return bonsCopains;
	}

	public void setBonsCopains(List<FichePlante> bonsCopains) {
		this.bonsCopains = bonsCopains;
	}

	public List<FichePlante> getMauvaisCopains() {
		return mauvaisCopains;
	}

	public void setMauvaisCopains(List<FichePlante> mauvaisCopains) {
		this.mauvaisCopains = mauvaisCopains;
	}

	public List<FicheMaladie> getMaladiesPlante() {
		return maladiesPlante;
	}

	public void setMaladiesPlante(List<FicheMaladie> maladiesPlante) {
		this.maladiesPlante = maladiesPlante;
	}

	public List<FicheRavageur> getRavageursPlante() {
		return ravageursPlante;
	}

	public void setRavageurs(List<FicheRavageur> ravageursPlante) {
		this.ravageursPlante = ravageursPlante;
	}

	public String getMethodeSemer() {
		return methodeSemer;
	}

	public void setMethodeSemer(String methodeSemer) {
		this.methodeSemer = methodeSemer;
	}

	public String getMethodePlanter() {
		return methodePlanter;
	}

	public void setMethodePlanter(String methodePlanter) {
		this.methodePlanter = methodePlanter;
	}

	public String getMethodeEntretien() {
		return methodeEntretien;
	}

	public void setMethodeEntretien(String methodeEntretien) {
		this.methodeEntretien = methodeEntretien;
	}

	public String getMethodeRecolte() {
		return methodeRecolte;
	}

	public void setMethodeRecolte(String methodeRecolte) {
		this.methodeRecolte = methodeRecolte;
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
		FichePlante other = (FichePlante) obj;
		return Objects.equals(id, other.id);
	}
	
	
}