package formation.sopra.vgarden.model;

import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name = "comptes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "compte", length=50)
@SequenceGenerator(name = "seqCompte", sequenceName = "seq_compte", initialValue = 100, allocationSize = 1)
@NamedQueries({ @NamedQuery(query = "select c from Compte c", name = "Employe.findAll"),
	@NamedQuery(query = "select c from Compte c where c.login=:login and c.password=:password", name = "Employe.findByCompteByLoginAndPassword")})
public abstract class Compte implements UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCompte")
	@Column(name = "id")
	protected Long id;
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z]((_)?([a-zA-Z0-9]{1,}))*$")
	@Column(name = "login", unique = true, length = 50)
	@NotEmpty
	protected String login;
	@Column(name = "password", length = 150)
	protected String password;
	@Enumerated(EnumType.STRING)
	@CollectionTable(name = "users_roles")
	protected Role role;
	private boolean enable = true;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isEnable() {
		return enable;
	}



	public void setEnable(boolean enable) {
		this.enable = enable;
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
