package fr.pizzeria.model;

public class Pizza {

	
	@ToString
	private String code;
	@ToString
	private String nom;
	@ToString
	private double prix;
	@ToString
	CategoriePizza type;

	public Pizza( String code, String nom, double prix, CategoriePizza type) {
		
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.type = type;
	}



	public Pizza( String code, String nom, double prix) {
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		
	}



	public String toString() {
//		String pPizza="";
//		for (Field field: this.getClass().getDeclaredFields()){
//			ToString annotation =field.getAnnotation(ToString.class);
//			if(annotation!=null){
//				//pPizza+=" "+field.get(this).toString().;
//			}
//		}

		String pPizza = (this.code + " " + this.nom + " " + this.prix + " " + this.type);
		return pPizza;

	}

	public CategoriePizza getType() {
		return type;
	}

	public void setType(CategoriePizza type) {
		this.type = type;
	}

	

	public String getCode() {
		return code;
	}

	public String getNom() {
		return nom;
	}

	public double getPrix() {
		return prix;
	}


	public void setCode(String code) {
		this.code = code;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
}
