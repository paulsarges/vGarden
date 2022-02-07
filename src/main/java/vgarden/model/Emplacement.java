package vgarden.model;

import javax.persistence.Embeddable;

@Embeddable
public class Emplacement {
	
	private double positionX;
	private double positionY;
	
		
	public Emplacement() {
		
	}

	public Emplacement(double positionX, double positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
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
	
	
}
