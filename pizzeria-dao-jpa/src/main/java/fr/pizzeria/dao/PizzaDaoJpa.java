package fr.pizzeria.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJpa implements IPizzaDao {

	
	private EntityManagerFactory emFact;
	
	public PizzaDaoJpa() {
		this.emFact =  Persistence.createEntityManagerFactory("pizzeria-unit");
	}
	
	@Override
	public List<Pizza> findAllPizzas() throws SQLException, ClassNotFoundException {
		List<Pizza> pizzas = new ArrayList<>();
		
		EntityManager em = emFact.createEntityManager();
		
		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p",Pizza.class);
		
		pizzas = query.getResultList();
	
		em.close();
		
		return pizzas;
		
		
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SQLException {
		EntityManager em = emFact.createEntityManager();
		
		EntityTransaction transac =em.getTransaction();
		transac.begin();
		
		em.persist(pizza);
		transac.commit();
		em.close();
		
		return true;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException, SQLException {
		EntityManager em = emFact.createEntityManager();
		
		EntityTransaction transac =em.getTransaction();
		transac.begin();
		
		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p WHERE p.code=:codePizza",Pizza.class);
		query.setParameter("codePizza", codePizza);
		List listPizza = query.getResultList();
		
		if(listPizza != null && !listPizza.isEmpty()){
			Pizza pdb = (Pizza)listPizza.get(0);
			pdb.setCode(pizza.getCode());
			pdb.setNom(pizza.getNom());
			pdb.setPrix(pizza.getPrix());
			pdb.setType(pizza.getType());
		}
		
		transac.commit();
		em.close();
		
		return true;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException, SQLException {
		EntityManager em = emFact.createEntityManager();
		EntityTransaction transac =em.getTransaction();
		transac.begin();
		
		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p WHERE p.code=:codePizza",Pizza.class);
		query.setParameter("codePizza", codePizza);
		Pizza laPizza = query.getResultList().get(0);
		
		if(laPizza != null ){
			em.remove(laPizza);
		}
		
		transac.commit();
		em.close();
		
		return true;
	}

}
