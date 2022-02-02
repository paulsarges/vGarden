package vgarden.model;

public class Particulier extends Utilisateur {
	
	private Adresse adresse;
	private static double taxe;	
	

	public Particulier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	@Override
	public String toString() {
		return "Particulier [id=" + id + ", login=" + login + ", password=" + password + ", typeCompte=" + typeCompte
				+ "]";
	}
	
	
	
	

}
