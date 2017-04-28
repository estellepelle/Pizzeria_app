package fr.pizzeria.console;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import fr.pizzeria.model.Commande;

public class test {

	@Test
	public void test() {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		
		EntityManagerFactory emFact = null;
	
		emFact =  Persistence.createEntityManagerFactory("pizzeria-unit");
		EntityManager em = emFact.createEntityManager();
		EntityTransaction transac =em.getTransaction();
		transac.begin();
		
		
		Query query = em.createQuery("SELECT c FROM Commande c WHERE c.id=1");
		Commande c = (Commande) query.getSingleResult();
		System.out.println(c.getIdLivreur().getNom().toString());
		System.out.println(c.getPizzas().iterator().next().getCode());

	}

}
