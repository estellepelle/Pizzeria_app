package fr.pizzeria.dao.pizza;

import java.sql.SQLException;

import fr.pizzeria.model.Client;

public interface IClientDao {
	boolean saveNewPizza(Client client) throws SQLException;
	boolean updatePizza(String codeClient, Client client)throws  SQLException;
	boolean deletePizza(String codeClient) throws  SQLException;
}
