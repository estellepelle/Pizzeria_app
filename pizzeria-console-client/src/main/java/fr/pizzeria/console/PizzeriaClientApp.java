package fr.pizzeria.console;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;

import fr.pizzeria.dao.ClientDaoJpa;
import fr.pizzeria.dao.pizza.IClientDao;
import fr.pizzeria.ihm.MenuClient;

public class PizzeriaClientApp {

	public static void main(String[] args) throws SQLException {
		
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		
		IClientDao clientDao = new ClientDaoJpa();

		Scanner question = new Scanner(System.in);
		MenuClient unMenu = new MenuClient(question,clientDao);
		
		// Initalisation des instances

		int choixMenu = 0;
		while (choixMenu != 99) {
			
			
			// Affichage du menu
			System.out.println("***** Pizzeria Client*****");
			unMenu.afficher();
			System.out.println("99. Sortir");
			
			// Poser une question
			choixMenu = question.nextInt();
		
			switch (choixMenu) {
			case 1:
				unMenu.getInsClient().execute();
			break;
			case 2:
				System.out.println("valide pour connection");;
			break;
		
			}	
			
		}
	}
}
