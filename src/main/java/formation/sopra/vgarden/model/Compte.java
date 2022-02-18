package formation.sopra.vgarden.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "comptes")
@SequenceGenerator(name = "seqCompte", sequenceName = "seq_compte", initialValue = 100, allocationSize = 1)
@NamedQueries({ @NamedQuery(query = "select c from Compte c", name = "Employe.findAll"),
	@NamedQuery(query = "select c from Compte c where c.login=:login and c.password=:password", name = "Employe.findByCompteByLoginAndPassword")})
public class Compte implements UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCompte")
	@Column(name = "id")
	@JsonView(Views.Common.class)
	protected Long id;
	@NotNull
	@Pattern(regexp = "^[a-zA-Z]((_)?([a-zA-Z0-9]{1,}))*$")
	@Column(name = "login", unique = true, length = 50)
	@NotNull
	protected String login;
	@Column(name = "password", length = 150)
	protected String password;
	@Enumerated(EnumType.STRING)
	@CollectionTable(name = "users_roles")
	protected Role role;
	private boolean enable = true;
	@OneToOne(mappedBy = "compte")
	@JsonView(Views.Common.class)
	private Utilisateur utilisateur;
	@Version
	private int version;

	public Compte() {
		super();
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
	
	

	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}



	public void setLogin(String login) {
		this.login = login;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}



	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}



	public boolean isEnable() {
		return enable;
	}



	public void setEnable(boolean enable) {
		this.enable = enable;
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
		Compte other = (Compte) obj;
		return Objects.equals(id, other.id);
	}
	
}
