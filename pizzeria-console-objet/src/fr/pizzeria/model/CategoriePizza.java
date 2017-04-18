package fr.pizzeria.model;

public enum CategoriePizza {
	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");
	
	private String typeViande;
	
	private CategoriePizza(String typeViande){
		this.typeViande= typeViande;
	}

	public String getTypeViande() {
		return typeViande;
	}
	
	
}
