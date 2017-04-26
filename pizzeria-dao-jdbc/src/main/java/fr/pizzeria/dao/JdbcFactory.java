package fr.pizzeria.dao;

import fr.pizzeria.dao.pizza.IPizzaDao;

public class JdbcFactory implements DaoFactory {
	private IPizzaDao pizzaDao;
	
	@Override
	public IPizzaDao getPizzaDao() {
		return pizzaDao;
	}
	
	public JdbcFactory() {
		setPizzaDao(new PizzaDaoJdbc());
	}

	public void setPizzaDao(IPizzaDao pizzaDao) {
		this.pizzaDao = pizzaDao;
	}

}
