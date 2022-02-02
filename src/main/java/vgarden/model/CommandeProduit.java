package vgarden.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "commande_produit")
public class CommandeProduit {

	@EmbeddedId
	private CommandeProduitKey id;

	private Integer quantite;

	public CommandeProduit() {

	}

	public CommandeProduit(CommandeProduitKey id, Integer quantite) {
		super();
		this.id = id;
		this.quantite = quantite;
	}

	public CommandeProduitKey getId() {
		return id;
	}

	public void setId(CommandeProduitKey id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CommandeProduit that = (CommandeProduit) o;
		return id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
