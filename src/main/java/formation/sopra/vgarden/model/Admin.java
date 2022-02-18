package formation.sopra.vgarden.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
@SequenceGenerator(name = "seqCompte", sequenceName = "seq_admin", initialValue = 100, allocationSize = 1)
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "admin_id")),
	@AttributeOverride(name = "login", column = @Column(name = "admin_login", length = 50, nullable = false)),
	@AttributeOverride(name = "password", column = @Column(name = "admin_password", length = 50, nullable = false))
})
public class Admin extends Compte {

	public Admin() {
		super();

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
