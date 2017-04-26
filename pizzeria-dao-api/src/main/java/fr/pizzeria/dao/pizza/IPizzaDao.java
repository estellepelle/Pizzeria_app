package fr.pizzeria.dao.pizza;

import java.sql.SQLException;
import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	
	List<Pizza>findAllPizzas() throws SQLException, ClassNotFoundException;
	
	boolean saveNewPizza(Pizza pizza) throws SQLException;
	boolean updatePizza(String codePizza, Pizza pizza)throws UpdatePizzaException, SQLException;
	boolean deletePizza(String codePizza) throws DeletePizzaException, SQLException;
}
