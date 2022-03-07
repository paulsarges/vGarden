package formation.sopra.vgarden.repositories;

import formation.sopra.vgarden.model.Utilisateur;

public class Professionnel extends Utilisateur{

	private String numeroPro;


	public Professionnel() {
		super();
	}

	public String getNumeroPro() {
		return numeroPro;
	}


	public void setNumeroPro(String numeroPro) {
		this.numeroPro = numeroPro;
	}

}
