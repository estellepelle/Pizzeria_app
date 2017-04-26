package fr.pizzeria.ihm;

import java.sql.SQLException;
import java.util.List;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzaOptionMenu extends OptionMenu {
	
	IPizzaDao laPizzaDao;
	
	
	
	public ListerPizzaOptionMenu(IPizzaDao laPizzaDao){
		this.laPizzaDao = laPizzaDao;
		this.libelle="1. Lister les pizzas";
	}

	public boolean execute() throws SQLException, ClassNotFoundException {
		
		List<Pizza> pizzas = laPizzaDao.findAllPizzas();
		
		for (int i=0; i<pizzas.size(); i++){
			if (pizzas.get(i)!=null){
				System.out.println(pizzas.get(i).toString());
			}
		}
		
		System.out.println(pizzas.size() +" Pizzas");
		return true;
	}	
}
