package vgarden.model;

import java.util.Objects;

public abstract class Compte {

	protected Long id;
	protected String login;
	protected String password;
	protected String typeCompte;

	public Compte() {
		super();
	}

	public Compte(Long id, String login, String password, String typeCompte) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.typeCompte = typeCompte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}

	@Override
	public int hashCode() {
		return Objects.hash(login, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		return Objects.equals(login, other.login) && Objects.equals(password, other.password);
	}
}
