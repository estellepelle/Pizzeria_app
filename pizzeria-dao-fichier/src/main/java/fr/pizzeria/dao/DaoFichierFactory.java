package fr.pizzeria.dao;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoImplFichier;

public class DaoFichierFactory implements DaoFactory {
	
	private static final String DATA_DIR = "data";

	private IPizzaDao pizzaDao = new PizzaDaoImplFichier(DATA_DIR);
	@Override
	public IPizzaDao getPizzaDao() {
		// TODO Auto-generated method stub
		return pizzaDao;
	}

}
