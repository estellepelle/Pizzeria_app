package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;
import fr.pizzeria.model.Pizza;

public class DaoMemoireFactory implements DaoFactory {

//	private List<Pizza> pizzas = new ArrayList<Pizza>();
	private IPizzaDao pizzaDao; 
	
	
	
	public DaoMemoireFactory() {
		this.pizzaDao =new PizzaDaoImpl();
	
	}
	
	@Override
	public IPizzaDao getPizzaDao() {

		return pizzaDao;
	}

}
