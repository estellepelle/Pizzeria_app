package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu{
	
	IPizzaDao laPizzaDao;
	private Scanner question = new Scanner(System.in);;
	
	public ModifierPizzaOptionMenu(Scanner question,IPizzaDao laPizzaDao){
		this.question=question;
		this.laPizzaDao = laPizzaDao;
		this.libelle="3. Mettre à jour une pizza";
	}
	
	public boolean execute()  {
		System.out.println("Veuillez choisir la pizza à modifier:");
		String codeAModifier = question.next();
		
		System.out.println("Veuillez saisir un code:");
		String code = question.next();
		System.out.println("Veuillez saisir un libelle:");
		String libelle = question.next();
		System.out.println("Veuillez saisir un prix:");
		double prix = question.nextDouble();
		System.out.println("Veuillez choisir une categorie (VIANDE, POISSON,SANS_VIANDE):");
		String type= question.next();
		CategoriePizza leType = CategoriePizza.valueOf(type);
		
		Pizza pizza = new Pizza(0, code,libelle,prix, leType);
		
		try {
			laPizzaDao.updatePizza(codeAModifier, pizza) ;
		} catch (UpdatePizzaException e) {
			// TODO Auto-generated catch block
			System.out.println("Pizza inexistante.");
		}
		return true;
	}
}
