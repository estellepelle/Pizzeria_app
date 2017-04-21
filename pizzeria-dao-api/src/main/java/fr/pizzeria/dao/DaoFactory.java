package fr.pizzeria.dao;

import fr.pizzeria.dao.pizza.IPizzaDao;

public interface DaoFactory {
	
	IPizzaDao getPizzaDao();
	
	
}
