package fr.pizzeria.ihm;

import java.sql.SQLException;
import java.util.Scanner;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;

public class SupprimerPizzaOptionMenu extends OptionMenu{
	
	IPizzaDao laPizzaDao;
	private Scanner question = new Scanner(System.in);
	
	public SupprimerPizzaOptionMenu(Scanner question,IPizzaDao laPizzaDao){
		this.question=question;
		this.laPizzaDao = laPizzaDao;
		this.libelle="4. Supprimer une pizza";
	}
	
	public boolean execute() throws SQLException {
		System.out.println("Veuillez choisir la pizza à supprimer:");
		String codeASupprimer = question.next();
		
		try {
			laPizzaDao.deletePizza(codeASupprimer);
		} catch (DeletePizzaException e) {
			// TODO Auto-generated catch block
			System.out.println("Pizza inexistante.");
		}
		
		return true;
	}
}
