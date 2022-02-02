package vgarden.model;

import java.util.List;




public class Terrain {
	private int surface;
	private String localisation;
	private double durreExpoSoleil;
	private double decoupageTerrainLongeur;
	private double decoupageTerrainLargeur;
	private TypeDeSol typeDeSol;
	private List<Plante> plantes;
	
	public Terrain(int surface, String localisation, double durreExpoSoleil) {
		this.surface = surface;
		this.localisation = localisation;
		this.durreExpoSoleil = durreExpoSoleil;
	}

	public int getSurface() {
		return surface;
	}

	public String getLocalisation() {
		return localisation;
	}

	public double getDurreExpoSoleil() {
		return durreExpoSoleil;
	}

	public List<Plante> getPlantes() {
		return plantes;
	}

	public void setSurface(int surface) {
		this.surface = surface;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public void setDurreExpoSoleil(double durreExpoSoleil) {
		this.durreExpoSoleil = durreExpoSoleil;
	}

	public void setPlantes(List<Plante> plantes) {
		this.plantes = plantes;
	}
	
	public void ajouterPlantes(Plante p) {
		this.plantes.add(p);
	}
	
	public void SupprimerPlante(Plante p) {
		this.plantes.remove(p);
	}

	

	public double getDecoupageTerrainLongeur() {
		return decoupageTerrainLongeur;
	}

	public void setDecoupageTerrainLongeur(double decoupageTerrainLongeur) {
		this.decoupageTerrainLongeur = decoupageTerrainLongeur;
	}

	public double getDecoupageTerrainLargeur() {
		return decoupageTerrainLargeur;
	}

	public void setDecoupageTerrainLargeur(double decoupageTerrainLargeur) {
		this.decoupageTerrainLargeur = decoupageTerrainLargeur;
	}

	public TypeDeSol getTypeDeSol() {
		return typeDeSol;
	}

	public void setTypeDeSol(TypeDeSol typeDeSol) {
		this.typeDeSol = typeDeSol;
	}
	
	
	@Override
	public String toString() {
		return "Terrain [surface=" + surface + ", localisation=" + localisation + ", durreExpoSoleil=" + durreExpoSoleil
				+ "]";
	}
	
}
