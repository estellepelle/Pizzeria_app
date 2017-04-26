package fr.pizzeria.ihm;

import java.sql.SQLException;
import java.util.Scanner;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class NouvellePizzaOptionMenu extends OptionMenu {
	
	
	IPizzaDao laPizzaDao;
	private Scanner question = new Scanner(System.in);
	static int idPizza=0;
	
	public NouvellePizzaOptionMenu(Scanner question,IPizzaDao laPizzaDao){
		this.question=question;
		this.laPizzaDao= laPizzaDao;
		this.libelle="2. Ajouter une nouvelle pizza ";
	}
	
	public boolean execute() throws SQLException {
		System.out.println("Veuillez saisir un code:");
		String code = question.next();
		System.out.println("Veuillez saisir un libelle:");
		String libelle = question.next();
		System.out.println("Veuillez saisir un prix:");
		double prix = question.nextDouble();
		System.out.println("Veuillez choisir une categorie (VIANDE, POISSON,SANS_VIANDE):");
		String type= question.next();
		CategoriePizza leType = CategoriePizza.valueOf(type);
		
		Pizza pizza = new Pizza(code,libelle,prix,leType);
		laPizzaDao.saveNewPizza(pizza);
		
		return true;
	}
}
