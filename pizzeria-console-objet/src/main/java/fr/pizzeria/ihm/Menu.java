package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.pizza.IPizzaDao;

public class Menu {
	
	private Scanner question = new Scanner(System.in);
	
	ListerPizzaOptionMenu listPizza;
	NouvellePizzaOptionMenu newPizza;
	ModifierPizzaOptionMenu modifPizza;
	SupprimerPizzaOptionMenu suppPizza;
	
	
	public Menu(Scanner questions,IPizzaDao laPizzaDao){
		
		
		
		this.listPizza = new ListerPizzaOptionMenu(laPizzaDao);
		this.newPizza = new NouvellePizzaOptionMenu(question,laPizzaDao) ;
		this.modifPizza = new ModifierPizzaOptionMenu(question,laPizzaDao);
		this.suppPizza = new SupprimerPizzaOptionMenu(question,laPizzaDao);
		
		
	}
	
	
	public void afficher(){
		
		
		System.out.println(listPizza.getLibelle());
		System.out.println(newPizza.getLibelle());
		System.out.println(modifPizza.getLibelle());
		System.out.println(suppPizza.getLibelle());
	}


	public ListerPizzaOptionMenu getListPizza() {
		return listPizza;
	}


	public NouvellePizzaOptionMenu getNewPizza() {
		return newPizza;
	}


	public ModifierPizzaOptionMenu getModifPizza() {
		return modifPizza;
	}


	public SupprimerPizzaOptionMenu getSuppPizza() {
		return suppPizza;
	}
	
	

	

	
}
