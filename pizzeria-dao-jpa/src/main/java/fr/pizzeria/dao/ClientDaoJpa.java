package fr.pizzeria.dao;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.pizzeria.dao.pizza.IClientDao;
import fr.pizzeria.model.Client;

public class ClientDaoJpa implements IClientDao{

	private EntityManagerFactory emFact;
	
	public ClientDaoJpa() {
		this.emFact =  Persistence.createEntityManagerFactory("pizzeria-unit");
	}
	
	@Override
	public boolean saveNewPizza(Client client) throws SQLException {
		EntityManager em = emFact.createEntityManager();
		
		EntityTransaction transac =em.getTransaction();
		transac.begin();
		
		em.persist(client);
		transac.commit();
		em.close();
		return true;
	}

	@Override
	public boolean updatePizza(String codeClient, Client client) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePizza(String codeClient) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	
}
