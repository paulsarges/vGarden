package formation.sopra.vgarden.model;

public enum TypePlante {
	Ail("Ail"), Aubergine("Aubergine"), Betterave("Betterave"), Carotte("Carotte"), Concombre("Concombre"),
	Céléri("Céléri"), Chou("Chou"), Courge("Courge"), Courgette("Cougette"), Fenouil, Fraisier, Haricot, Laitue, Melon, Poireau, Pois, Poivron, Radis, Tomate}
	private String nom;
	
	private TypePlante(String nom) {
		this.nom = nom;
	}
	public String getNom() {
		return this.nom;
	}
	}
