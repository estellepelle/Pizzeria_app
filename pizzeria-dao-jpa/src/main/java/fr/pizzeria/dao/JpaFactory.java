package fr.pizzeria.dao;

import javax.persistence.EntityManagerFactory;

import fr.pizzeria.dao.DaoFactory;
import fr.pizzeria.dao.pizza.IPizzaDao;

public class JpaFactory implements DaoFactory {
	private IPizzaDao pizzaDao;
	
	public JpaFactory() {
		pizzaDao =  new PizzaDaoJpa();
	}
	
	
	@Override
	public IPizzaDao getPizzaDao() {
		
		return pizzaDao;
	}

	public void setPizzaDao(IPizzaDao pizzaDao) {
		this.pizzaDao = pizzaDao;
	}

}
