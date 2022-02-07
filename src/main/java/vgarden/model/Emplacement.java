package vgarden.model;

import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class Emplacement {
	
	private double positionX;
	private double positionY;
	private Plante plante;
	
		
	public Emplacement() {
		
	}

	public Emplacement(double positionX, double positionY, Plante plante) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.plante = plante;
	}

	public double getPositionX() {
		return positionX;
	}

	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}

	public double getPositionY() {
		return positionY;
	}

	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}

	public Plante getPlante() {
		return plante;
	}

	public void setPlante(Plante plante) {
		this.plante = plante;
	}

	@Override
	public int hashCode() {
		return Objects.hash(plante, positionX, positionY);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emplacement other = (Emplacement) obj;
		return Objects.equals(plante, other.plante)
				&& Double.doubleToLongBits(positionX) == Double.doubleToLongBits(other.positionX)
				&& Double.doubleToLongBits(positionY) == Double.doubleToLongBits(other.positionY);
	}
	
}
