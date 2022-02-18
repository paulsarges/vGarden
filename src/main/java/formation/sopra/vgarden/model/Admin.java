package formation.sopra.vgarden.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@DiscriminatorValue(value = "administrateur")
public class Admin extends Compte {

	public Admin() {
		super();
		this.role = Role.ROLE_ADMIN;

	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new HashSet<GrantedAuthority>(Arrays.asList(new SimpleGrantedAuthority(this.role.toString())));
	}

	@Override
	public String getUsername() {
		return this.login;
	}
	
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}


	public double NombreTransaction() {
		return 0;
	}

	static double totalTaxexObtenus() {
		return 0;
	}

	static void supprimerCompte(Utilisateur u) {

	}

}
