package fr.pizzeria.console;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionBase {
	
	public static void main(String[] args) throws SQLException{
		try {
			Class.forName ("com.mysql.jdbc.Driver");
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria","root","");
			Statement statement = myConnection.createStatement();
			ResultSet resultat = statement.executeQuery("SELECT count(*) FROM pizzas");
			int compteur = 0;
			if (resultat.next()){
				compteur = resultat.getInt(1);
			}
			
			PreparedStatement selectPizzaSt = myConnection.prepareStatement("SELECT * FROM pizzas WHERE id=? " );
			for(int i=1; i<=compteur; i++){
				selectPizzaSt.setInt(1, i);
				ResultSet resultatFinal = selectPizzaSt.executeQuery();
				
				if(resultatFinal.next()){
					String code = resultatFinal.getString("code");
					String nom = resultatFinal.getString("nom");
					BigDecimal prix = resultatFinal.getBigDecimal("prix");
				
				
					System.out.println(code+" " + nom +" " +prix);
				}
				
				resultatFinal.close();
				resultat.close();
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
