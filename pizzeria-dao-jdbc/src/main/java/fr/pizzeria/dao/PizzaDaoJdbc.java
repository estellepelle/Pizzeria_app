package fr.pizzeria.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJdbc implements IPizzaDao {

	private static ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
	
	static{try {
		Class.forName (bundle.getString("jdbc-driver"));
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}};
	
	//pizza dans base de donnees
	public List<Pizza> findAllPizzas() throws SQLException {
		Connection myConnection = DriverManager.getConnection(bundle.getString("jdbc-host"),bundle.getString("jdbc-user"),bundle.getString("jdbc-mdp"));
		Statement statement = myConnection.createStatement();
		
		List<Pizza> pizzas =  new ArrayList<>();
		   
			ResultSet resultat;
			try {
				resultat = statement.executeQuery("SELECT * FROM pizzas");
				while(resultat.next()){
					
					int id=resultat.getInt("id");
					String code = resultat.getString("code");
					String nom = resultat.getString("nom");
					double prix = resultat.getDouble("prix");
					String type=resultat.getString("type");
					
					
					 
					
	
					pizzas.add(new Pizza(code,nom,prix,CategoriePizza.valueOf(type)));
				}	
				
				resultat.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		return pizzas;	
		
	}

	//ajouter une pizza dans BD 
	public boolean saveNewPizza(Pizza pizza) throws SQLException {
		try {
			Connection myConnection = DriverManager.getConnection(bundle.getString("jdbc-host"),bundle.getString("jdbc-user"),bundle.getString("jdbc-mdp"));
			Statement statement = myConnection.createStatement();
			
			String nom = pizza.getNom();
			String code = pizza.getCode();
			Double prix = pizza.getPrix();
			CategoriePizza type= pizza.getType();
			
			int inserePizza =statement.executeUpdate("INSERT INTO pizzas(code,nom,prix,type) VALUES('"+code + "','"+nom +"','"+prix+"','"+type+"')");
			
			statement.close();
			myConnection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

	//modifier une pizza dans BD
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException, SQLException {
		try {
			Connection myConnection = DriverManager.getConnection(bundle.getString("jdbc-host"),bundle.getString("jdbc-user"),bundle.getString("jdbc-mdp"));
			Statement statement = myConnection.createStatement();
			
			String nom = pizza.getNom();
			String code = pizza.getCode();
			Double prix = pizza.getPrix();
			CategoriePizza type= pizza.getType();
			
			int modifPizza =statement.executeUpdate("UPDATE pizzas SET code='"+code+"',nom='"+nom+"',prix ='" +prix+ "',type='"+type+"'WHERE code='"+codePizza+"'");
			statement.close();
			myConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

	//supprimer une pizza dans BD
	public boolean deletePizza(String codePizza) throws DeletePizzaException, SQLException {
		try {
			Connection myConnection = DriverManager.getConnection(bundle.getString("jdbc-host"),bundle.getString("jdbc-user"),bundle.getString("jdbc-mdp"));
			Statement statement = myConnection.createStatement();
			
			
			int supPizza =statement.executeUpdate("DELETE FROM pizzas WHERE code='"+codePizza+"'");
			
			statement.close();
			myConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
		
	}
	
	

}
