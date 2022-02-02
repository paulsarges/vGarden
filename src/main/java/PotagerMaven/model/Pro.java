package PotagerMaven.model;

public class Pro extends Utilisateur {
	
	private Adresse adresse;
	private static double taxe;
	
	public Pro() {
		super();
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}



}
