package fr.pizzeria.ihm;

import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoImplFichier;
import fr.pizzeria.model.Pizza;

public class ImportDonnees extends OptionMenu {

	private static final String DATA_DIR = "data";
	
	IPizzaDao laPizzaDao;
	
	public ImportDonnees(IPizzaDao laPizzaDao) {
		this.laPizzaDao = laPizzaDao;
		this.libelle="5. Import donnees";
	}
	
	@Override
	public boolean execute() throws SQLException, ClassNotFoundException {
		
		
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String value = bundle.getString("dao.impl");
		
		if(value.equals("fr.pizzeria.dao.JdbcFactory")){
			PizzaDaoImplFichier daoFichier = new PizzaDaoImplFichier(DATA_DIR);
			List <Pizza> pizzas = daoFichier.findAllPizzas();
			
			for(Pizza p:pizzas){
				laPizzaDao.saveNewPizza(p);
			}
		}else{
			System.out.println("Veuillez configurer l’application avec une implémentation base de données");
		}
		
		return true;
	}

}
