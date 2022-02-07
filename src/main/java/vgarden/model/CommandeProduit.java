package vgarden.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "commande_produit")
public class CommandeProduit {

	@EmbeddedId
	private CommandeProduitKey id;

	@Column(name = "commande_produit_quantite", nullable = false)
	private Integer quantite;

	public CommandeProduit() {

	}

	public CommandeProduit(CommandeProduitKey id, Integer quantite) {
		this.id = id;
		this.quantite = quantite;
	}

	public CommandeProduitKey getId() {
		return id;
	}

	public void setId(CommandeProduitKey id) {
		this.id = id;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
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
