package fr.pizzeria.console;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;


import com.github.lalyos.jfiglet.FigletFont;

import fr.pizzeria.dao.DaoFactory;
import fr.pizzeria.dao.DaoFichierFactory;
import fr.pizzeria.dao.DaoMemoireFactory;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;
import fr.pizzeria.ihm.*;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String value = bundle.getString("dao.impl");
		
		System.out.println(value);
		Class<?> maClasse = Class.forName(value);
		
		//daoFactory
		DaoFactory  daoFactory =  (DaoFactory) maClasse.newInstance();
		
		
		// TODO Auto-generated method stub
		Scanner question = new Scanner(System.in);
		List<Pizza> pizzas = new ArrayList<Pizza>();
		
		
		String asciiArt;
	
		asciiArt = FigletFont.convertOneLine("Pizzeria-app");
		System.out.println(asciiArt);
	
	    
		
		Menu unMenu = new Menu(question, daoFactory.getPizzaDao());
		
		

		// Initialisation du tdb des pizzas
		initialisationPizzas(pizzas);

		// Initalisation des instances

		int choixMenu = 0;
		while (choixMenu != 99) {

			// Affichage du menu
			System.out.println("***** Pizzeria Administration *****");
			unMenu.afficher();
			System.out.println("99. Sortir");

			// Poser une question
			choixMenu = question.nextInt();

			// Analyse de la r�ponse � la question
			switch (choixMenu) {
			case 1:
				unMenu.getListPizza().execute();
				break;
			case 2:
				unMenu.getNewPizza().execute();
				break;
			case 3:
				unMenu.getListPizza().execute();
				unMenu.getModifPizza().execute();
				break;
			case 4:
				unMenu.getListPizza().execute();
				unMenu.getSuppPizza().execute();
				break;
			default:
				break;
			}
		}
		question.close();

	}

	private static void initialisationPizzas(List<Pizza> pizzas) {
		pizzas.add(new Pizza(PizzaDaoImpl.codePizza++, "PEP", "P�p�roni", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(PizzaDaoImpl.codePizza++, "MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza(PizzaDaoImpl.codePizza++, "REI", "La Reine", 11.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(PizzaDaoImpl.codePizza++, "FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza(PizzaDaoImpl.codePizza++, "CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(PizzaDaoImpl.codePizza++, "SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(PizzaDaoImpl.codePizza++, "ORI", "L�orientale", 13.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(PizzaDaoImpl.codePizza++, "IND", "L�indienne", 14.00, CategoriePizza.VIANDE));
	}

}
