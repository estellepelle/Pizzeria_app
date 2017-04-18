package fr.pizzeria.console;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.ihm.*;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner question = new Scanner(System.in);
		List<Pizza> pizzas = new ArrayList<Pizza>();

		IPizzaDao laPizzaDao = new PizzaDaoImpl(pizzas);
		Menu unMenu = new Menu(question, laPizzaDao);

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

			// Analyse de la réponse à la question
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
		pizzas.add(new Pizza(PizzaDaoImpl.codePizza++, "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(PizzaDaoImpl.codePizza++, "MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza(PizzaDaoImpl.codePizza++, "REI", "La Reine", 11.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(PizzaDaoImpl.codePizza++, "FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza(PizzaDaoImpl.codePizza++, "CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(PizzaDaoImpl.codePizza++, "SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(PizzaDaoImpl.codePizza++, "ORI", "L’orientale", 13.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(PizzaDaoImpl.codePizza++, "IND", "L’indienne", 14.00, CategoriePizza.VIANDE));
	}

}
