package PotagerMaven.model;

public class Admin extends Compte {

	public Admin() {
		super();
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", login=" + login + ", password=" + password + ", typeCompte=" + typeCompte + "]";
	}

	
	
}
