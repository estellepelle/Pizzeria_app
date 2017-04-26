package fr.pizzeria.console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionBase {
	
	public static void main(String[] args) throws SQLException{
		try {
			Class.forName ("com.mysql.jdbc.Driver");
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria","root","");
			Statement statement = myConnection.createStatement();
			ResultSet resultat = statement.executeQuery("SELECT * FROM pizzas");
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
